package com.java.service.role;

import java.util.List;
import java.util.Map;

import com.java.po.RolepermissionKey;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年3月11日 下午2:40:44 
* 类说明 
*/



public interface RolePermissionService {
	public int insert(RolepermissionKey rolepermissionKey);
	public int update(List<String> list, String role);
	public Map<String, Object> query(String name);
	public int delete(String name);
}
