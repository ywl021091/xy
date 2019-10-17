package com.java.service.usercustomer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CustomerMapper;
import com.java.dao.UsercustomerMapper;
import com.java.po.Customer;
import com.java.po.Usercustomer;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年5月30日 下午2:14:18 
* 类说明 
*/
@Service
public class UserCustomerServiceImpl implements UserCustomerService {
	@Autowired
	private UsercustomerMapper usercustomerMapper;
	@Autowired
	private CustomerMapper customerMapper;
	//全部删除重新赋值
	@Override
	public int update(List<String> list,int id) {
		int r = 0;
		try {
			r = usercustomerMapper.deleteByUserID(id);
		} catch (Exception e) {
			return r ;
		}
		
		Usercustomer usercustomer = new Usercustomer(id);
		
		for (int i = 0; i < list.size(); i++) {
			Customer customer = customerMapper.selectByCustomername(list.get(i));
			usercustomer.setCustomerid(customer.getCustomerid());
			usercustomerMapper.insert(usercustomer);
		}
		return r;
	}
	//全部删除
		@Override
		public int delete(int id) {
			int r = 0;
			try {
				r = usercustomerMapper.deleteByUserID(id);
			} catch (Exception e) {
				return r ;
			}
			return r;
		}
	@Override
	public Map<String, Object> select(int userid) {
		//获取所有客户列表
		Customer customer = new Customer();
		List<Customer> list = customerMapper.queryCustomer(customer);
		//获取本角色客户列表
		List<Usercustomer> list2= usercustomerMapper.select(userid);
		//可赋予客户
		List<String> strlist1 = new ArrayList<>();
		//已有客户
		List<String> strlist2 = new ArrayList<>();
		//转化为字符串列表
		for (int i = 0; i < list.size(); i++) {
		
			strlist1.add(list.get(i).getCustomername());
		}
		for (int i=0; i<list2.size(); i++) {
			int fid = list2.get(i).getCustomerid();
			Customer customer2 = customerMapper.selectByid(fid);
			strlist2.add(customer2.getCustomername());
		}
		strlist1.removeAll(strlist2);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("strlist1", strlist1);
		resultMap.put("strlist2", strlist2);
		return resultMap;
	}
	
}
