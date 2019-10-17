package com.java.service.curdata;

import java.util.List;
import java.util.Map;

import com.java.po.CurData;


/**
* @Author Li Zongsheng	E-mail:lizs07216819@163.com
* @Date 2019年4月2日 上午8:35:11 
* @Version 1.0
*/

public interface CurdataService {
    
    public List<String> selectMacList();
    
    //public CurData selectCurData(String mac);
    
    public List<CurData> selectWarn(String sbsbm);

    public Map<String, Object> selectWarnValue(Integer start, Integer length, String sbsbm);
}
