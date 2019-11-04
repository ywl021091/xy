package com.java.provider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.java.po.Customer;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月13日 下午3:17:51 
* 类说明 
*/
public class CustomerProvider {
	//客户模糊查询 2019/3/28 郑广润
		public String queryCustomer(Customer customer) {
			String customernum = customer.getCustomernum();
			String customername = customer.getCustomername();
			String province = customer.getProvince();
			String city = customer.getCity();
			String linkman = customer.getLinkman();
			String category = customer.getCategory();
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			HttpSession session = request.getSession();
			String usernum = session.getAttribute("usernum").toString();
			String sql = new SQL() {
				{
					SELECT("*");
					FROM("customer");
					if (customernum == null || customernum == "") {
					} else {
						WHERE("customernum like concat('%',#{customernum},'%')");
					}
					if (customername == null || customername == "") {
					} else {
						WHERE("customername like concat('%',#{customername},'%')");
					}
					if (province == null || province == "") {
					} else {
						WHERE("province like concat('%',#{province},'%')");
					}
					if (city == null || city == "") {
					} else {
						WHERE("city like concat('%',#{city},'%')");
					}
					if (linkman == null || linkman == "") {
					} else {
						WHERE("linkman like concat('%',#{linkman},'%')");
					}
					if (category == null || category == "") {
					} else {
						WHERE("category like concat('%',#{category},'%')");
					}
					WHERE("customerid in (SELECT customerid FROM usercustomer WHERE userid=(SELECT sysuserid FROM sysuser WHERE usernum = '"+usernum+"'))");
				}
			}.toString();
			return sql;
		}
		
		
		public String queryCustomerAll(Customer customer) {
			String customernum = customer.getCustomernum();
			String customername = customer.getCustomername();
			String province = customer.getProvince();
			String city = customer.getCity();
			String linkman = customer.getLinkman();
			String category = customer.getCategory();
			String sql = new SQL() {
				{
					SELECT("*");
					FROM("customer");
					if (customernum == null || customernum == "") {
					} else {
						WHERE("customernum like concat('%',#{customernum},'%')");
					}
					if (customername == null || customername == "") {
					} else {
						WHERE("customername like concat('%',#{customername},'%')");
					}
					if (province == null || province == "") {
					} else {
						WHERE("province like concat('%',#{province},'%')");
					}
					if (city == null || city == "") {
					} else {
						WHERE("city like concat('%',#{city},'%')");
					}
					if (linkman == null || linkman == "") {
					} else {
						WHERE("linkman like concat('%',#{linkman},'%')");
					}
					if (category == null || category == "") {
					} else {
						WHERE("category like concat('%',#{category},'%')");
					}
				}
			}.toString();
			return sql;
		}
}
