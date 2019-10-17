package com.java.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Sysuser {
    private Integer sysuserid;
	
    private Integer roleid;

    private String usernum;

    private String sex;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date birthday;

    private String address;

    private String job;

    private String dept;

    private String tel;

    private String note;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date lastupdate;

    private String pass;

    private String name;

    public Integer getSysuserid() {
        return sysuserid;
    }

    public void setSysuserid(Integer sysuserid) {
        this.sysuserid = sysuserid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getUsernum() {
        return usernum;
    }

    public void setUsernum(String usernum) {
        this.usernum = usernum == null ? null : usernum.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "Sysuser [sysuserid=" + sysuserid + ", roleid=" + roleid + ", usernum=" + usernum + ", sex=" + sex
				+ ", birthday=" + birthday + ", address=" + address + ", job=" + job + ", dept=" + dept + ", tel=" + tel
				+ ", note=" + note + ", lastupdate=" + lastupdate + ", pass=" + pass + ", name=" + name + "]";
	}
    
}