package com.java.service.templatecontrast;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.TemplateContrastMapper;
import com.java.po.TemplateContrast;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年8月27日 上午8:53:44 
* 类说明 
*/
@Service
public class TemplateContrastServiceImpl implements TemplateContrastService{
	@Autowired
	private TemplateContrastMapper templatecontrastmapper;
	@Override
	public List<TemplateContrast> queryTemplateContrast() {
		List<TemplateContrast> list = templatecontrastmapper.getlist();
		return list;
	}
	@Override
	public TemplateContrast select(String templatenum) {
		TemplateContrast templateContrast = templatecontrastmapper.select(templatenum);
		return templateContrast;
	}
	@Override
	public TemplateContrast selectByid(int templateid) {
		TemplateContrast templateContrast = templatecontrastmapper.selectByid(templateid);
		return templateContrast;
	}

}
