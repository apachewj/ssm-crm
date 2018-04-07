package com.ssm.crm.service;

import com.ssm.crm.dao.CustomerMapper;
import com.ssm.crm.dao.DictMapper;
import com.ssm.crm.pojo.BaseDict;
import com.ssm.crm.pojo.Customer;
import com.ssm.crm.pojo.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
		
	@Autowired
	private DictMapper dictMapper; //接口与映射文件不在一个目录时，这里经常报红，不不影响运行
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<BaseDict> findDictByCode(String code) {
		return dictMapper.findDictByCode(code);
	}

	@Override
	public Integer findCustomerCountByVo(QueryVo queryVo) {
		return customerMapper.findCustomerCountByVo(queryVo);
	}

	@Override
	public List<Customer> findCustomerByVo(QueryVo queryVo) {
		return customerMapper.findCustomerByVo(queryVo);
	}

	@Override
	public List<Customer> findCustomerByPage(QueryVo vo) {
		return customerMapper.findCustomerByPage(vo);
	}

	@Override
	public Customer findCustomerById(Long id) {
		return customerMapper.findCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerMapper.deleteCustomer(id);
	}
	
}
