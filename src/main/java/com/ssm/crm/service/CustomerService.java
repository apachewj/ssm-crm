package com.ssm.crm.service;

import com.ssm.crm.pojo.BaseDict;
import com.ssm.crm.pojo.Customer;
import com.ssm.crm.pojo.QueryVo;

import java.util.List;

public interface CustomerService {
	
	public List<BaseDict> findDictByCode(String code);
	
	/**
	 * 分页条件查询，计算总数
	 * @param queryVo
	 * @return
	 */
	public Integer findCustomerCountByVo(QueryVo queryVo);
	/**
	 * 分页条件查询
	 * @param queryVo
	 * @return
	 */
	public List<Customer> findCustomerByVo(QueryVo queryVo);

	/**
	 *  通过PageHelper实现分页
	 * @param vo
	 */
	public List<Customer> findCustomerByPage(QueryVo vo);

	/**
	 * 根据id查询客户信息
	 */
	public Customer findCustomerById(Long id);
	
	/**
	 * 更新单个指定的客户信息
	 * @param customer
	 */
	public void updateCustomer(Customer customer);
	
	/**
	 * 删除单个指定的客户信息
	 * @param id
	 */
	public void deleteCustomer(Long id);

}
