package com.java.po;

public class Usercustomer {
    private Integer userid;

    private Integer customerid;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

	public Usercustomer(Integer userid, Integer customerid) {
		super();
		this.userid = userid;
		this.customerid = customerid;
	}

	public Usercustomer() {
		super();
	}

	public Usercustomer(Integer userid) {
		super();
		this.userid = userid;
	}
    
}