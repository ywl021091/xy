package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.java.po.Customer;

@Mapper
public interface CustomerMapper {
	@Delete("delete from customer where customerid = #{customerid}")
	public int deleteByPrimaryKey(Integer customerid);
	@Insert("insert into customer(customernum, customername, province, city, linkman, sex, address, category,tel, recorddate,note,lastupdate) values(#{customernum}, #{customername},#{province}, #{city}, #{linkman},#{sex}, #{address}, #{category},#{tel}, #{recorddate}, #{note},#{lastupdate})")
	public int insert(Customer customer);
	@Update("update customer set customernum = #{customernum}, customername = #{customername},province = #{province}, city = #{city}, linkman = #{linkman}, sex = #{sex}, address = #{address}, category = #{category},tel = #{tel}, recorddate = #{recorddate},note = #{note},lastupdate = #{lastupdate} where customerid = #{customerid}")
	public int updateByPrimaryKey(Customer customer);
	@SelectProvider(type=com.java.provider.CustomerProvider.class,method="queryCustomer")
	public List<Customer> queryCustomer(Customer customer);
	@Select("select * from customer where customerid = #{customerid}")
	public Customer selectByid(int customerid);
	@Select("select * from customer where customernum = #{customernum}")
	public Customer selectByCustomernum(String customernum);
	@Select("select * from customer where customername = #{customername}")
	public Customer selectByCustomername(String customername);
	@Select("select * from customer")
	public List<Customer> query();
}