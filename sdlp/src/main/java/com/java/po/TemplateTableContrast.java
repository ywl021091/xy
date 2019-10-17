package com.java.po;

public class TemplateTableContrast {
    private Integer templatetableid;

    private String templatetablename;

    private String templatenum;

    public Integer getTemplatetableid() {
        return templatetableid;
    }

    public void setTemplatetableid(Integer templatetableid) {
        this.templatetableid = templatetableid;
    }

    public String getTemplatetablename() {
        return templatetablename;
    }

    public void setTemplatetablename(String templatetablename) {
        this.templatetablename = templatetablename == null ? null : templatetablename.trim();
    }

    public String getTemplatenum() {
        return templatenum;
    }

    public void setTemplatenum(String templatenum) {
        this.templatenum = templatenum == null ? null : templatenum.trim();
    }

	public TemplateTableContrast(Integer templatetableid, String templatetablename, String templatenum) {
		super();
		this.templatetableid = templatetableid;
		this.templatetablename = templatetablename;
		this.templatenum = templatenum;
	}

	public TemplateTableContrast() {
		super();
	}
    
}