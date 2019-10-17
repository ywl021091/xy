package com.java.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年7月5日 上午8:52:53 
* 类说明 
*/
public class TerminalResult {
	 private Integer terminalid;

	    private String mtype;

	    private String isuse;

	    private String owner;

	    private Integer customerid;
	    
	    private String customernum;

	    private String devicenum;

	    private String note;
	    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	    private Date usedate;
	    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	    private Date lastupdate;

	    private Float longitude;

	    private Float latitude;

	    private String province;

	    private String city;

	    private String mac;

	    public Integer getTerminalid() {
	        return terminalid;
	    }

	    public void setTerminalid(Integer terminalid) {
	        this.terminalid = terminalid;
	    }
	    
	    public String getMtype() {
	        return mtype;
	    }

	    public void setMtype(String mtype) {
	        this.mtype = mtype == null ? null : mtype.trim();
	    }

	    public String getIsuse() {
	        return isuse;
	    }

	    public void setIsuse(String isuse) {
	        this.isuse = isuse == null ? null : isuse.trim();
	    }

	    public String getOwner() {
	        return owner;
	    }

	    public void setOwner(String owner) {
	        this.owner = owner == null ? null : owner.trim();
	    }

	    public Integer getCustomerid() {
	        return customerid;
	    }

	    public void setCustomerid(Integer customerid) {
	        this.customerid = customerid;
	    }

	    public String getDevicenum() {
	        return devicenum;
	    }

	    public void setDevicenum(String devicenum) {
	        this.devicenum = devicenum == null ? null : devicenum.trim();
	    }

	    public String getNote() {
	        return note;
	    }

	    public void setNote(String note) {
	        this.note = note == null ? null : note.trim();
	    }

	    public Date getUsedate() {
	        return usedate;
	    }

	    public void setUsedate(Date usedate) {
	        this.usedate = usedate;
	    }

	    public Date getLastupdate() {
	        return lastupdate;
	    }

	    public void setLastupdate(Date lastupdate) {
	        this.lastupdate = lastupdate;
	    }

	    public Float getLongitude() {
	        return longitude;
	    }

	    public void setLongitude(Float longitude) {
	        this.longitude = longitude;
	    }

	    public Float getLatitude() {
	        return latitude;
	    }

	    public void setLatitude(Float latitude) {
	        this.latitude = latitude;
	    }

	    public String getProvince() {
	        return province;
	    }

	    public void setProvince(String province) {
	        this.province = province == null ? null : province.trim();
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city == null ? null : city.trim();
	    }

	    public String getMac() {
	        return mac;
	    }

	    public void setMac(String mac) {
	        this.mac = mac == null ? null : mac.trim();
	    }

		public String getCustomernum() {
			return customernum;
		}

		public void setCustomernum(String customernum) {
			this.customernum = customernum;
		}

}
