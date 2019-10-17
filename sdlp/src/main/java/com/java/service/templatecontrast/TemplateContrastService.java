package com.java.service.templatecontrast;
/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年8月27日 上午8:52:28 
* 类说明 
*/

import java.util.List;

import com.java.po.TemplateContrast;

public interface TemplateContrastService {
	//查询所有
	public List<TemplateContrast> queryTemplateContrast();
	//通过代号查询一个
	public TemplateContrast select(String templatenum);
	//通过编号查询一个
	public TemplateContrast selectByid(int templateid);
}
