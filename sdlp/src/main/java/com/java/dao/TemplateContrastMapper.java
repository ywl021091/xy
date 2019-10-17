package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.java.po.TemplateContrast;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年8月27日 上午8:27:02 
* 类说明 
*/
@Mapper
public interface TemplateContrastMapper {
	//查询所有终端类型
	@Select("select * from templatecontrast")
	public List<TemplateContrast> getlist();
	//查询所有终端类型
	@Select("select * from templatecontrast where templatenum = #{templatenum}")
	public TemplateContrast select(String templatenum);
	//查询所有终端类型
	@Select("select * from templatecontrast where templateid = #{templateid}")
	public TemplateContrast selectByid(int templateid);
}
