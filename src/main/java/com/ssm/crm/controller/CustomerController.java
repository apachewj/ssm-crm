package com.ssm.crm.controller;

import cn.itcast.utils.Page;
import com.ssm.crm.pojo.BaseDict;
import com.ssm.crm.pojo.Customer;
import com.ssm.crm.pojo.QueryVo;
import com.ssm.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Value("${customer.dict.source}")
	private String source;
	@Value("${customer.dict.industry}")
	private String industry;
	@Value("${customer.dict.level}")
	private String level;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String list(QueryVo vo, Model model) throws Exception {
		//查询字典
		List<BaseDict> sourceList = customerService.findDictByCode(source);
		List<BaseDict> industryList = customerService.findDictByCode(industry);
		List<BaseDict> levelList = customerService.findDictByCode(level);
		
		//处理get方式乱码
		String custName = vo.getCustName();
		if (custName != null && "".equals(custName)) {
			vo.setCustName(new String(custName.getBytes("iso-8859-1"),"utf-8"));
		}

		//条件查询总条数
		Integer count = customerService.findCustomerCountByVo(vo);
		//计算起始索引
		vo.setStart((vo.getPage()-1)*vo.getSize());
		
		//查询数据
		List<Customer> rows = customerService.findCustomerByVo(vo);
		
		Page<Customer> page = new Page<Customer>();
		page.setPage(vo.getPage());
		page.setSize(vo.getSize());
		page.setTotal(count);
		page.setRows(rows);
		
		//分页数据放入model
		model.addAttribute("page", page);
		
		//字典数据存入model
		model.addAttribute("fromType", sourceList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		
		//回显搜索条件
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	/**
	 * 编辑客户信息准备
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Customer editCustomer(Long id) {
		Customer customer = customerService.findCustomerById(id);
		return customer;
	}
	
	/**
	 * 更新客户信息
	 */
	@RequestMapping("update")
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updateCustomer(customer);
		return "ok";
	}
	
	/**
	 * 删除客户信息
	 */
	@RequestMapping("delete")
	@ResponseBody
	public String deleteCustomer(Long id) {
		customerService.deleteCustomer(id);
		return "ok";
	}
}
