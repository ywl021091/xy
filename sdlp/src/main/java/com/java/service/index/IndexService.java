package com.java.service.index;

import com.java.model.TerminalDataResult;

public interface IndexService {
	//查询指定设备最近最后修改时间的一条数据
	TerminalDataResult selectLastData(String mac);
}
