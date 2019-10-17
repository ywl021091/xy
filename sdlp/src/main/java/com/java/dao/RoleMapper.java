package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.java.po.Role;

@Mapper
public interface RoleMapper {
	@Delete("Delete from role where roleid=#{roleid}")
    int deleteByPrimaryKey(int roleid);
	@Insert("insert into role(name) values(#{name})")
    int insert(String name);
    @Select("select * from role where roleid=#{roleid}")
    public Role selectByPrimaryKey(Integer roleid);
    @Select("select * from role where name=#{name}")
    public Role selectByName(String name);
	@Update("update role set name=#{name} where roleid=#{roleid}")
	public int update(Role role);
	@SelectProvider(type=com.java.provider.RoleProvider.class,method="queryRole")
	public List<Role> queryRole(String name);
}