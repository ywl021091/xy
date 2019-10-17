package com.java.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Simcard {
    private Integer simcardid;

    private String simid;

    private String phone;

    private Short isuse;

    private Integer terminalid;

    private String note;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date lastupdate;

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
        this.simid = simid == null ? null : simid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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
		return "Simcard [simcardid=" + simcardid + ", simid=" + simid + ", phone=" + phone + ", isuse=" + isuse
				+ ", terminalid=" + terminalid + ", note=" + note + ", lastupdate=" + lastupdate + "]";
	}
    
}