package com.java.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/** 
* @author 郑广润  E-mail: 489551132@qq.com
* @version 创建时间：2019年6月18日 上午9:02:34 
* 类说明 
*/
public class SimcardResult {
	 	private Integer simcardid;

	    private String simid;

	    private String phone;

	    private Short isuse;

	    private Integer terminalid;

	    private String note;
	    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	    private Date lastupdate;
	    
	    private String devicenum;

		public Integer getSimcardid() {
			return simcardid;
		}

		public void setSimcardid(Integer simcardid) {
			this.simcardid = simcardid;
		}

		public String getSimid() {
			return simid;
		}

		public void setSimid(String simid) {
			this.simid = simid;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Short getIsuse() {
			return isuse;
		}

		public void setIsuse(Short isuse) {
			this.isuse = isuse;
		}

		public Integer getTerminalid() {
			return terminalid;
		}

		public void setTerminalid(Integer terminalid) {
			this.terminalid = terminalid;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public Date getLastupdate() {
			return lastupdate;
		}

		public void setLastupdate(Date lastupdate) {
			this.lastupdate = lastupdate;
		}

		public String getDevicenum() {
			return devicenum;
		}

		public void setDevicenum(String devicenum) {
			this.devicenum = devicenum;
		}
	    
}
