package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.java.po.Usercustomer;


@Mapper
public interface UsercustomerMapper {
	@Insert("insert into usercustomer(userid,customerid) values(#{userid},#{customerid})")
	public int insert(Usercustomer usercustomer);
	@Delete("delete from usercustomer where userid = #{userid}")
	public int deleteByUserID(int userid);
    @Select("select userid,customerid from usercustomer where userid = #{userid}")
    public List<Usercustomer> select(int userid);
}