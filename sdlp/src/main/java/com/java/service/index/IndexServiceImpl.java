package com.java.service.index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.IndexMapper;
import com.java.model.TerminalDataResult;

@Service
public class IndexServiceImpl implements IndexService{
	@Autowired
	private IndexMapper indexMapper;
	
	@Override
	public TerminalDataResult selectLastData(String mac) {
		TerminalDataResult tr = indexMapper.selectLastData(mac);
		//System.out.println(tr);
		return tr;
	}

}
