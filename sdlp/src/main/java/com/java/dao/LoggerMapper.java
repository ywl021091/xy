package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import com.java.po.Loginfo;

@Mapper
public interface LoggerMapper {

	@SelectProvider(type=com.java.provider.GetLoggerProvider.class,method="queryLogger")
	public List<Loginfo> queryLogger(@Param("date")String date, @Param("operator")String operator);
	
	@Insert("insert into loginfo(date,operator,operation) values(#{date},#{operator},#{operation})")
	public Integer insertLog(Loginfo logInfo);
}
