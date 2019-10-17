package com.java.service.templatetable;

import java.util.List;


import com.java.po.TemplateTable;
import com.java.po.TemplateTableContrast;
/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年8月26日 下午3:09:42 
* 类说明 
*/
public interface TemplateTableService {
		//增终端类型名
		public int insertTemplateTable(String templatetablename);
		//增终端类型与参数关系
		public int insertTemplateTableContrast(TemplateTableContrast templatetablecontrast);
		//查所有终端类型名称
		public List<TemplateTable> getlist(String templatetablename);
		//删除一个终端类型
		public int deleteTemplateTable(String templatetablename);
		//删除终端类型与模板参数关系
		public int deleteTemplateTableContrast(String templatetablename);
		//查一个终端类型所有参数
		public List<TemplateTableContrast> query(String templatetablename);	
		//增终端类型名 Controller
		public int insert(List<String> list,String templatetablename);
}
