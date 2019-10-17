package com.java.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CurData {
    private String mac;

    private String devicenum;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date timestamp;

    private Boolean pb50;
    
    private Boolean pb51;

    private Boolean pb52;

    private Boolean pb53;

    private Boolean pb54;

    private Boolean pb55;

    private Boolean pb56;

    private Boolean pb57;

    private Boolean pb58;

    private Boolean pb59;

    private Boolean pb60;

    private Boolean pb61;

    private Boolean pb62;

    private Boolean pb63;

    private Boolean pb64;
    
    private Boolean pb65;
    
    private Boolean pb66;
    
    private Boolean pb67;
    
    private Boolean pb68;

    private Float pf16;

    private Float pf17;

    private Float pf18;

    private Float pf25;

    private Float pf26;

    private Float pf27;

    private Float pf28;

    private Float pf29;

    private Float pf30;

    private Float pf40;

    private Float pf41;

    private Float pf42;

    private Float pf43;

    private Float pf51;

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getDevicenum() {
		return devicenum;
	}

	public void setDevicenum(String devicenum) {
		this.devicenum = devicenum;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Boolean getPb50() {
		return pb50;
	}

	public void setPb50(Boolean pb50) {
		this.pb50 = pb50;
	}

	public Boolean getPb51() {
		return pb51;
	}

	public void setPb51(Boolean pb51) {
		this.pb51 = pb51;
	}

	public Boolean getPb52() {
		return pb52;
	}

	public void setPb52(Boolean pb52) {
		this.pb52 = pb52;
	}

	public Boolean getPb53() {
		return pb53;
	}

	public void setPb53(Boolean pb53) {
		this.pb53 = pb53;
	}

	public Boolean getPb54() {
		return pb54;
	}

	public void setPb54(Boolean pb54) {
		this.pb54 = pb54;
	}

	public Boolean getPb55() {
		return pb55;
	}

	public void setPb55(Boolean pb55) {
		this.pb55 = pb55;
	}

	public Boolean getPb56() {
		return pb56;
	}

	public void setPb56(Boolean pb56) {
		this.pb56 = pb56;
	}

	public Boolean getPb57() {
		return pb57;
	}

	public void setPb57(Boolean pb57) {
		this.pb57 = pb57;
	}

	public Boolean getPb58() {
		return pb58;
	}

	public void setPb58(Boolean pb58) {
		this.pb58 = pb58;
	}

	public Boolean getPb59() {
		return pb59;
	}

	public void setPb59(Boolean pb59) {
		this.pb59 = pb59;
	}

	public Boolean getPb60() {
		return pb60;
	}

	public void setPb60(Boolean pb60) {
		this.pb60 = pb60;
	}

	public Boolean getPb61() {
		return pb61;
	}

	public void setPb61(Boolean pb61) {
		this.pb61 = pb61;
	}

	public Boolean getPb62() {
		return pb62;
	}

	public void setPb62(Boolean pb62) {
		this.pb62 = pb62;
	}

	public Boolean getPb63() {
		return pb63;
	}

	public void setPb63(Boolean pb63) {
		this.pb63 = pb63;
	}

	public Boolean getPb64() {
		return pb64;
	}

	public void setPb64(Boolean pb64) {
		this.pb64 = pb64;
	}

	public Boolean getPb65() {
		return pb65;
	}

	public void setPb65(Boolean pb65) {
		this.pb65 = pb65;
	}

	public Boolean getPb66() {
		return pb66;
	}

	public void setPb66(Boolean pb66) {
		this.pb66 = pb66;
	}

	public Boolean getPb67() {
		return pb67;
	}

	public void setPb67(Boolean pb67) {
		this.pb67 = pb67;
	}

	public Boolean getPb68() {
		return pb68;
	}

	public void setPb68(Boolean pb68) {
		this.pb68 = pb68;
	}

	public Float getPf16() {
		return pf16;
	}

	public void setPf16(Float pf16) {
		this.pf16 = pf16;
	}

	public Float getPf17() {
		return pf17;
	}

	public void setPf17(Float pf17) {
		this.pf17 = pf17;
	}

	public Float getPf18() {
		return pf18;
	}

	public void setPf18(Float pf18) {
		this.pf18 = pf18;
	}

	public Float getPf25() {
		return pf25;
	}

	public void setPf25(Float pf25) {
		this.pf25 = pf25;
	}

	public Float getPf26() {
		return pf26;
	}

	public void setPf26(Float pf26) {
		this.pf26 = pf26;
	}

	public Float getPf27() {
		return pf27;
	}

	public void setPf27(Float pf27) {
		this.pf27 = pf27;
	}

	public Float getPf28() {
		return pf28;
	}

	public void setPf28(Float pf28) {
		this.pf28 = pf28;
	}

	public Float getPf29() {
		return pf29;
	}

	public void setPf29(Float pf29) {
		this.pf29 = pf29;
	}

	public Float getPf30() {
		return pf30;
	}

	public void setPf30(Float pf30) {
		this.pf30 = pf30;
	}

	public Float getPf40() {
		return pf40;
	}

	public void setPf40(Float pf40) {
		this.pf40 = pf40;
	}

	public Float getPf41() {
		return pf41;
	}

	public void setPf41(Float pf41) {
		this.pf41 = pf41;
	}

	public Float getPf42() {
		return pf42;
	}

	public void setPf42(Float pf42) {
		this.pf42 = pf42;
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
		return "CurData [mac=" + mac + ", devicenum=" + devicenum + ", timestamp=" + timestamp + ", pb50=" + pb50
				+ ", pb51=" + pb51 + ", pb52=" + pb52 + ", pb53=" + pb53 + ", pb54=" + pb54 + ", pb55=" + pb55
				+ ", pb56=" + pb56 + ", pb57=" + pb57 + ", pb58=" + pb58 + ", pb59=" + pb59 + ", pb60=" + pb60
				+ ", pb61=" + pb61 + ", pb62=" + pb62 + ", pb63=" + pb63 + ", pb64=" + pb64 + ", pb65=" + pb65
				+ ", pb66=" + pb66 + ", pb67=" + pb67 + ", pb68=" + pb68 + ", pf16=" + pf16 + ", pf17=" + pf17
				+ ", pf18=" + pf18 + ", pf25=" + pf25 + ", pf26=" + pf26 + ", pf27=" + pf27 + ", pf28=" + pf28
				+ ", pf29=" + pf29 + ", pf30=" + pf30 + ", pf40=" + pf40 + ", pf41=" + pf41 + ", pf42=" + pf42
				+ ", pf43=" + pf43 + ", pf51=" + pf51 + "]";
	}

	

    

    
}
