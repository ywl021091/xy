package com.java.service.usercustomer;
/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年5月30日 下午2:10:12 
* 类说明 
*/

import java.util.List;
import java.util.Map;

public interface UserCustomerService {
	//改
	public int update(List<String> list,int id);
	//查
	public Map<String, Object> select(int userid);
	//删
	public int delete(int id);
}
