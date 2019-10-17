package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.java.po.CurData;

/**
* @Author Li Zongsheng	E-mail:lizs07216819@163.com
* @Date 2019年4月2日 上午8:34:13 
* @Version 1.0
*/
@Mapper
public interface CurdataMapper {
    
    @Select("SELECT mac FROM curdata")
    public List<String> selecMacList();
    
    @Select("SELECT mac,devicenum,timestamp,pb50,pb51,pb52,pb53,pb54,pb55,pb56,pb57,pb58,pb59,pb60,pb61,pb62,pb63,pb64,pb65,pb66,pb67,pb68,pf16,pf17,pf18,pf25,pf26,pf27,pf28,pf29,pf30,pf40,pf41,pf42,pf43,pf51 FROM curData")
    public List<CurData> selectWarn();
    
    //@Select("SELECT mac,devicenum,timestamp,cs8,cs11,cs12,cs14,cs15,cs23,cs31,cs34,cs35,cs36,cs37,cs38,cs39,cs40,cs41,cs42,cs43,cs44,cs45,cs46,cs16,cs17,cs18,cs19,cs20,cs21,cs22,cs24,cs25,cs26,cs27,cs28,cs29,cs30,cs32,cs33 FROM curdata WHERE mac=#{mac}")
    //public CurData selectCurData(String mac);
    
    @Select("SELECT mac,devicenum,timestamp,pb50,pb51,pb52,pb53,pb54,pb55,pb56,pb57,pb58,pb59,pb60,pb61,pb62,pb63,pb64,pb65,pb66,pb67,pb68,pf16,pf17,pf18,pf25,pf26,pf27,pf28,pf29,pf30,pf40,pf41,pf42,pf43,pf51 FROM curData where mac=(SELECT mac FROM terminal WHERE devicenum=#{sbsbm})")
    public List<CurData> selectWarnBySBSBM(String sbsbm);
    

}
