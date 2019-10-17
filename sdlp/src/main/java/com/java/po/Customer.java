package com.java.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Customer {
    private Integer customerid;

    private String customernum;

    private String customername;

    private String province;

    private String city;

    private String linkman;

    private String sex;

    private String address;

    private String category;

    private String tel;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date recorddate;

    private String note;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date lastupdate;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomernum() {
        return customernum;
    }

    public void setCustomernum(String customernum) {
        this.customernum = customernum == null ? null : customernum.trim();
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername == null ? null : customername.trim();
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

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customernum=" + customernum + ", customername=" + customername
				+ ", province=" + province + ", city=" + city + ", linkman=" + linkman + ", sex=" + sex + ", address="
				+ address + ", category=" + category + ", tel=" + tel + ", recorddate=" + recorddate + ", note=" + note
				+ ", lastupdate=" + lastupdate + "]";
	}
    
    
}