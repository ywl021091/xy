package com.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.java.model.TerminalDataResult;

@Mapper
public interface IndexMapper {
		//查询最近最后修改时间的一条数据
		@Select("SELECT gdid, pb13, pb19, pb22, pb25, pb28, pb31, pb34, pb35, pb56, pf16, pf25, pf28, pf34, pf40, pf43, pf51 FROM terminaldata WHERE mac=#{mac} ORDER BY timestamp DESC LIMIT 1;")
		public TerminalDataResult selectLastData(String mac);
}
