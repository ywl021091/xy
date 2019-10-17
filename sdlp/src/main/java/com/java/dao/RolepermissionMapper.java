package com.java.dao;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.java.po.RolepermissionKey;

@Mapper
public interface RolepermissionMapper {
	@Delete("Delete from rolepermission where roleid=#{roleid}")
    int deleteByPrimaryKey(int roleid);
	@Insert("insert into rolepermission(roleid,permissionid) values(#{roleid},#{permissionid})")
    int insert(RolepermissionKey rolepermissionKey);
    @Select("select * from rolepermission where roleid=#{roleid}")
    public List<RolepermissionKey> getlistrolepermission(int roleid);
}