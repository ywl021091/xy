package com.java.service.citymap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.CityMapMapper;
import com.java.po.Terminal;

/**
* @Author Li Zongsheng	E-mail:lizs07216819@163.com
* @Date 2019年3月13日 上午9:42:03 
* @Version 1.0
*/
@Service
public class CityMapServiceImpl implements CityMapService{

    @Autowired
    CityMapMapper cityMapper;
    
    public List<Terminal> queryLongitudeAndLatitude(String province, String city) {
        List<Terminal> longitudeAndLatitude = cityMapper.queryLongitudeAndLatitude(province,city);
        //System.out.println("Service:"+longitudeAndLatitude);
        return longitudeAndLatitude;
        
    }

    @Override
    public List<Terminal> queryLongitudeAndLatitudeBySBSBM(String province, String city) {
        List<Terminal> longitudeAndLatitude = cityMapper.queryLongitudeAndLatitudeBySBSBM(province,city);
        //System.out.println("Service:"+longitudeAndLatitude);
        return longitudeAndLatitude;
    }

    @Override
    public String queryCustomername(Integer customerid) {
        
        String customername = cityMapper.queryCustomername(customerid);
        
        return customername;
    }
    
    
}
