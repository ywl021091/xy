package com.java.service.simcard;

import java.util.Map;

import com.java.model.SimcardResult;
import com.java.po.Simcard;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月18日 上午9:47:40 
* 类说明 
*/


public interface SimcardService {
	//增
	public int insert(Simcard simcard);
	//复杂模糊查询
	public Map<String, Object> selectSimList(Integer start, Integer length,String simid, String phone, Integer isuse, Integer terminalid);
	//通过ID获得对象
	SimcardResult selectId(Integer simcardid);
	//改
	Integer setSimList(Simcard simcard);
	//删
	Integer delSimList(Integer simcardid);
	//查一个
	Simcard getSimcard(Integer id);
	//批量导入查重
	boolean selectSimid(String excelSimId);
}
