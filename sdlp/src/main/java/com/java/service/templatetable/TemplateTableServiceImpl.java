package com.java.service.templatetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.TemplateTableMapper;
import com.java.po.TemplateTable;
import com.java.po.TemplateTableContrast;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年8月26日 下午3:16:13 
* 类说明 
*/
@Service
public class TemplateTableServiceImpl implements TemplateTableService {
	@Autowired
	private	TemplateTableMapper templatetablemapper;
	@Override
	public int insertTemplateTable(String templatetablename) {
		int i = 0;
		i = templatetablemapper.insertTemplateTable(templatetablename);
		return i;
	}
	@Override
	public int insertTemplateTableContrast(TemplateTableContrast templatetablecontrast) {
		int i = 0;
		try {
			i = templatetablemapper.insertTemplateTableContrast(templatetablecontrast);
		} catch (Exception e) {
		}	
		return i;
	}
	@Override
	public List<TemplateTable> getlist(String templatetablename) {
		List<TemplateTable> list= templatetablemapper.getListTemplateTable(templatetablename);
		return list;
	}

	@Override
	public int deleteTemplateTable(String templatetablename) {
		int i = 0;
		try {
			i = templatetablemapper.deleteTemplateTable(templatetablename);
		} catch (Exception e) {
		}	
		return i;
	}
	@Override
	public int deleteTemplateTableContrast(String templatetablename) {
		int i = 0;
		try {
			i = templatetablemapper.deleteTemplateTableContrast(templatetablename);
		} catch (Exception e) {
		}	
		return i;
	}
	@Override
	public List<TemplateTableContrast> query(String templatetablename) {
		List<TemplateTableContrast> list = templatetablemapper.query(templatetablename);
		return list;
	}
	//对应控制层方法
	@Override
	@Transactional
	public int insert(List<String> list, String templatetablename) {
		int r = 0;
		// 业务逻辑
		//处理参数
		if(templatetablename == "") {
			return r;
		}
		r = insertTemplateTable(templatetablename);
		TemplateTableContrast templatetablecontrast = new TemplateTableContrast();
		templatetablecontrast.setTemplatetablename(templatetablename);
		for (int i = 0; i < list.size(); i++) {
			templatetablecontrast.setTemplatenum(list.get(i));
			insertTemplateTableContrast(templatetablecontrast);
		}
		return r;
	}



	
}
