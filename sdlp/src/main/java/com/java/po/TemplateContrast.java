package com.java.po;

public class TemplateContrast {
    private Integer templateid;

    private String templatenum;

    private String templatename;

    private String address;

	public Integer getTemplateid() {
		return templateid;
	}

	public void setTemplateid(Integer templateid) {
		this.templateid = templateid;
	}

	public String getTemplatenum() {
		return templatenum;
	}

	public void setTemplatenum(String templatenum) {
		this.templatenum = templatenum;
	}

	public String getTemplatename() {
		return templatename;
	}

	public void setTemplatename(String templatename) {
		this.templatename = templatename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public TemplateContrast(Integer templateid, String templatenum, String templatename, String address) {
		super();
		this.templateid = templateid;
		this.templatenum = templatenum;
		this.templatename = templatename;
		this.address = address;
	}

	public TemplateContrast() {
		super();
	}
    
}