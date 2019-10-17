package com.java.service.customer;

import java.util.List;
import java.util.Map;

import com.java.po.Customer;

/**
 * @author 郑广润 E-mail: 489551132@qq.com
 * @version 创建时间：2019年3月26日 下午2:01:41 类说明
 */
public interface CustomerService {
	// 增
	public int insert(Customer customer);

	// 删
	public int delete(int i);

	// 改
	public int update(Customer customer);

	// 分页模糊查询
	public Map<String, Object> queryCustomer(Customer customer, int draw, int start, int length);
	
	//id查一个
	public Customer selectByid(int customerid);
	
	//名称查一个
	public Customer selectByCustomernum(String customernum);
	
	//返回客户接口列表
	public Map<String, Object> query();
	
	// 返回客户列表excel
	public List<Customer> ListCustomer();
		
}
