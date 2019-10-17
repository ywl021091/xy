package com.java.service.customer;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.CustomerMapper;
import com.java.po.Customer;


/**
 * @author 郑广润 E-mail: 489551132@qq.com
 * @version 创建时间：2019年3月27日 下午2:30:32 类说明
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public int insert(Customer customer) {
		int i = 0;
		try {
			i = customerMapper.insert(customer);
		} catch (Exception e) {
		}
		return i;
	}

	@Override
	public int delete(int customerid) {
		int i = 0;
		try {
			i = customerMapper.deleteByPrimaryKey(customerid);
		} catch (Exception e) {
		}
		return i;
	}

	@Override
	public int update(Customer customer) {
		int i = 0;
		try {
			i =  customerMapper.updateByPrimaryKey(customer);
		} catch (Exception e) {
		}
		return i;
	}

	@Override
	public Map<String, Object> queryCustomer(Customer customer, int draw, int start, int length) {
		// 使用PageHelper分页
		PageHelper.startPage((start/length)+1, length);
		List<Customer> list = customerMapper.queryCustomer(customer);
		PageInfo<Customer> pageinfo = new PageInfo<>(list);
		// 将得到的pageinfo类进行转化给datatable方便前台展示
		Map<String,Object> resultMap = new HashMap<String,Object>();
        resultMap.put("draw",draw);
        resultMap.put("recordsTotal",pageinfo.getTotal());
        resultMap.put("recordsFiltered",pageinfo.getTotal());
        resultMap.put("data",list);
		return resultMap;
	}

	@Override
	public Customer selectByid(int customerid) {
		return customerMapper.selectByid(customerid);
	}

	@Override
	public Customer selectByCustomernum(String customernum) {
		
		return customerMapper.selectByCustomernum(customernum);
	}

	@Override
	public Map<String, Object> query() {
		List<Customer> list = customerMapper.query();
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("list", list);
		return resultMap;
	}

	@Override
	public List<Customer> ListCustomer() {
		List<Customer> list = customerMapper.query();
		return list;
	}
	

}
