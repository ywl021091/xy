package com.java.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TerminalDataResult {
	private Integer gdid;
	private String batchid;
	private String mac;
	private String devicenumnum;
	@JsonFormat(pattern = "yyyy年MM月dd日", timezone="GMT+8")
	private Date timestamp;
	private Boolean pb13;
	private Boolean pb19;
	private Boolean pb22;
	private Boolean pb25;
	private Boolean pb28;
	private Boolean pb31;
	private Boolean pb34;
	private Boolean pb35;
	private Boolean pb56;
	private Float pf16;
	private Float pf25;
	private Float pf28;
	private Float pf34;
	private Float pf40;
	private Float pf43;
	private Float pf51;
	public Integer getGdid() {
		return gdid;
	}
	public void setGdid(Integer gdid) {
		this.gdid = gdid;
	}
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getDevicenumnum() {
		return devicenumnum;
	}
	public void setDevicenumnum(String devicenumnum) {
		this.devicenumnum = devicenumnum;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Boolean getPb13() {
		return pb13;
	}
	public void setPb13(Boolean pb13) {
		this.pb13 = pb13;
	}
	public Boolean getPb19() {
		return pb19;
	}
	public void setPb19(Boolean pb19) {
		this.pb19 = pb19;
	}
	public Boolean getPb22() {
		return pb22;
	}
	public void setPb22(Boolean pb22) {
		this.pb22 = pb22;
	}
	public Boolean getPb25() {
		return pb25;
	}
	public void setPb25(Boolean pb25) {
		this.pb25 = pb25;
	}
	public Boolean getPb28() {
		return pb28;
	}
	public void setPb28(Boolean pb28) {
		this.pb28 = pb28;
	}
	public Boolean getPb31() {
		return pb31;
	}
	public void setPb31(Boolean pb31) {
		this.pb31 = pb31;
	}
	public Boolean getPb34() {
		return pb34;
	}
	public void setPb34(Boolean pb34) {
		this.pb34 = pb34;
	}
	public Boolean getPb35() {
		return pb35;
	}
	public void setPb35(Boolean pb35) {
		this.pb35 = pb35;
	}
	public Boolean getPb56() {
		return pb56;
	}
	public void setPb56(Boolean pb56) {
		this.pb56 = pb56;
	}
	public Float getPf16() {
		return pf16;
	}
	public void setPf16(Float pf16) {
		this.pf16 = pf16;
	}
	public Float getPf25() {
		return pf25;
	}
	public void setPf25(Float pf25) {
		this.pf25 = pf25;
	}
	public Float getPf28() {
		return pf28;
	}
	public void setPf28(Float pf28) {
		this.pf28 = pf28;
	}
	public Float getPf34() {
		return pf34;
	}
	public void setPf34(Float pf34) {
		this.pf34 = pf34;
	}
	public Float getPf40() {
		return pf40;
	}
	public void setPf40(Float pf40) {
		this.pf40 = pf40;
	}
	public Float getPf43() {
		return pf43;
	}
	public void setPf43(Float pf43) {
		this.pf43 = pf43;
	}
	public Float getPf51() {
		return pf51;
	}
	public void setPf51(Float pf51) {
		this.pf51 = pf51;
	}
	@Override
	public String toString() {
		return "terminaldataResult [gdid=" + gdid + ", batchid=" + batchid + ", mac=" + mac + ", devicenumnum="
				+ devicenumnum + ", timestamp=" + timestamp + ", pb13=" + pb13 + ", pb19=" + pb19 + ", pb22=" + pb22
				+ ", pb25=" + pb25 + ", pb28=" + pb28 + ", pb31=" + pb31 + ", pb34=" + pb34 + ", pb35=" + pb35
				+ ", pb56=" + pb56 + ", pf16=" + pf16 + ", pf25=" + pf25 + ", pf28=" + pf28 + ", pf34=" + pf34
				+ ", pf40=" + pf40 + ", pf43=" + pf43 + ", pf51=" + pf51 + "]";
	}
	
}
