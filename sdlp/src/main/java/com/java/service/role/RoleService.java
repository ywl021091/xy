package com.java.service.role;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.java.po.Permission;
import com.java.po.Role;

/**
 * @author 郑广润 E-mail: 489551132@qq.com
 * @version 创建时间：2019年3月1日 上午9:23:00 角色接口
 */
public interface RoleService {
	// 增
	public int insert(String name);

	// 删除
	public int delete(int id);

	// 更新
	public int update(Role role);

	// 查询指定数据
	public Role queryusernumRole(String name);

	// 查询指定数据
	public Role queryRoleId(int id);

	// 分页模糊查询
	Map<String, Object> queryRole(int draw, int start, int length, String name);

	// 返回所有
	public Map<String, Object> query();
	
	//session中取角色名返回权限集合
	public List<Permission> selectByName(HttpSession session);
}
