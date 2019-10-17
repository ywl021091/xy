package com.java.service.simcard;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java.dao.SimcardMapper;
import com.java.model.SimcardResult;
import com.java.po.Simcard;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月18日 上午9:48:01 
* 类说明 
*/
@Service
public class SimcardServiceImpl implements SimcardService{
	@Autowired
	private SimcardMapper simcardMapper;
	@Override
	public int insert(Simcard simcard) {
		Date date = new Date();
		simcard.setLastupdate(date);
		int i = 0;
		try {
			i =simcardMapper.insert(simcard);
		} catch (Exception e) {
		}
		return i;
	}
	/**
	 *条件查询用户信息
	 */
	@Override
	public  Map<String, Object>  selectSimList(Integer start, Integer length,String simid,String phone,Integer isuse,Integer terminalid){
		PageHelper.startPage(((start / length) + 1), length);
		List<SimcardResult> simcardResults = simcardMapper.selectSimList(simid, phone, isuse, terminalid);
		// simcard表中展示终端信息表中的设备编码信息
		PageInfo<SimcardResult> pageInfo = new PageInfo<SimcardResult>(simcardResults);
		Map<String, Object> map = new HashMap<String, Object>();
		// 将总页数计算封存
		map.put("iTotalRecords", pageInfo.getTotal());
		map.put("iTotalDisplayRecords", pageInfo.getTotal());
		map.put("data", simcardResults);
		return map;
	}
	/**
	 * 根据id获取用户信息
	 */
	@Override
	public SimcardResult selectId(Integer simcardid) {
		return simcardMapper.selectByid(simcardid);
	}
	/**
	 * 修改用户信息
	 * @param simInfo
	 */
	@Override
	public Integer setSimList(Simcard simcard) {
		Date date = new Date();
		simcard.setLastupdate(date);
        try {
            return simcardMapper.update(simcard);
        } catch (Exception e) {
            return 0;
        }
	}
	/**
	 * 删除操作
	 */
	@Override
	public Integer delSimList(Integer simcardid) {
		return simcardMapper.delete(simcardid);
	}
	//查一个
	@Override
	public Simcard getSimcard(Integer id) {

		return simcardMapper.getSimcard(id);
	}
	//批量导入excel查重
	@Override
    public boolean selectSimid(String excelSimId) {
        List<String> simidList = simcardMapper.selectSimid();
        for(String simid:simidList){
            if(simid.equals(excelSimId)) {
                return false;
            }
        }
        return true;
    }
}
