package com.java.service.sysuser;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.SysuserMapper;
import com.java.model.SysuserResult;
import com.java.po.Sysuser;

@Service
public class SysuserServiceImpl implements SysuserService{
	@Autowired
	private SysuserMapper sysuserMapper;;
	//增
	@Override
	public int insert(Sysuser sysuser) {
		int i = 0;
		try {
			i = sysuserMapper.insert(sysuser);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}
	//查所有
	@Override
	public List<Sysuser> getlistuser() {
		return sysuserMapper.getlistuser();
	}
	//更新
	@Override
	public int update(Sysuser sysuser) {
		int i = 0;
		try {
			i = sysuserMapper.update(sysuser);
		} catch (Exception e) {
			
		}
		return i;
	}
	//删除
	@Override
	public int delete(int id) {
		int i = 0;
		try {
			i = sysuserMapper.delete(id);
		} catch (Exception e) {
		}
		return i;
	}
	@Override
	//通过用户名查询指定用户
	public Sysuser queryusernumSysuser(String usernum) {
		return sysuserMapper.queryUserNum(usernum);
	}
	@Override
	public Sysuser querySysuserId(int id) {
		return sysuserMapper.querySysuserId(id);
	}
	//分页模糊 查询
	@Override
	public Map<String, Object> querySysuser(int draw, int start, int length,String usernum,String name,String job,String dept,String authority) {
		// 使用PageHelper分页
		PageHelper.startPage(start, length);
		List<SysuserResult> list = sysuserMapper.querySysuser(usernum,name,job,dept,authority);
		PageInfo<SysuserResult> pageInfo = new PageInfo<>(list);
		// 将得到的pageinfo类进行转化给datatable方便前台展示
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("draw",draw);
        resultMap.put("recordsTotal",pageInfo.getTotal());
        resultMap.put("recordsFiltered",pageInfo.getTotal());
        resultMap.put("data",list);
		return resultMap;
	}
	@Override
	public HashSet<String> queryDept() {
		HashSet<String> result= sysuserMapper.queryDept();
		result.remove("");
		return result;
	}
	@Override
	public int resetPass(int id) {
		return sysuserMapper.resetPass(id);
	}
	@Override
	public int verifyPass(HttpServletRequest request, String oldpass) {
		HttpSession session = request.getSession();
		String usernum = (String) session.getAttribute("usernum");
		Sysuser sysuser = sysuserMapper.queryUserNum(usernum);
		//成功返回1
		//失败返回2
		if(oldpass.equals(sysuser.getPass())) {
			return 1;
		}else {
			return 0;
		}
	}
	//修改密码
	@Override
	public int updatePass(HttpServletRequest request,String oldpass,String newpass,String confirmpass) {
		int i = 0;
		try {
			i = verifyPass(request,oldpass);
		} catch (Exception e) {
			// TODO: handle exception
		}
		int r = 0;
		if(i == 1) {
			if(newpass.equals(confirmpass)) {
				HttpSession session = request.getSession();
				String usernum = (String) session.getAttribute("usernum");
				Sysuser sysuser = sysuserMapper.queryUserNum(usernum);
				int id = sysuser.getSysuserid();
				r = sysuserMapper.updatePass(id, newpass);
			}
		}
		return r;
	}
	@Override
	public int verifyUsernum(int id, String usernum) {
		List<Sysuser> list= sysuserMapper.getlistuser();
	    for (Sysuser syseuser : list) {
	        if(usernum.equals(syseuser.getUsernum())) {
	        	if(id != syseuser.getSysuserid()) {
	        		return 0;
	        	}
	        }
	    }
		return 1;
	}
}
