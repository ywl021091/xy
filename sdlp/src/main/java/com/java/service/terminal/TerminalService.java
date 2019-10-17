package com.java.service.terminal;

import java.util.List;
import java.util.Map;

import com.java.po.Terminal;


public interface TerminalService {
	//增
	public int insert(Terminal terminal);
	//删
	public int delete(int id);
	//改
	public int updata(Terminal terminal);
	//通过id查询指定信息
	public Terminal queryTerminalId(int id);
	//通过设备识别码num 判断是否存在数据
	public int queryNum(String num);
	//分页模糊查询 
    public Map<String, Object> queryTerminal(int draw, int start, int length,Terminal terminal, String customernum);

	List<Integer> getTeminalIdList();
	String getTeminalNum(Integer id);
}
