package com.java.service.citymap;

import java.util.List;

import com.java.po.Terminal;

/**
* @Author Li Zongsheng	E-mail:lizs07216819@163.com
* @Date 2019年3月13日 上午9:41:00 
* @Version 1.0
*/

public interface CityMapService {
    public List<Terminal> queryLongitudeAndLatitude(String province, String city) ;
    
    public List<Terminal> queryLongitudeAndLatitudeBySBSBM(String sbsbm,String province, String city) ;
    
    public String queryCustomername(Integer customerid);
}
