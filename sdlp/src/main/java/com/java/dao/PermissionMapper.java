package com.java.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.java.po.Permission;
@Mapper
public interface PermissionMapper {
    @Select("select * from permission where permissionid = #{permissionid}")
    public Permission selectByPrimaryKey(Integer permissionid);
    @Select("select * from permission where name = #{name}")
    public Permission selectByname(String name);
    @Select("select * from permission")
    public List<Permission> query();
}