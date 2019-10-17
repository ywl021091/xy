package com.java.po;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Loginfo {
    private Integer loginfoid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;

    private String operator;

    private String operation;

	public Integer getLoginfoid() {
		return loginfoid;
	}

	public void setLoginfoid(Integer loginfoid) {
		this.loginfoid = loginfoid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Loginfo [loginfoid=" + loginfoid + ", date=" + date + ", operator=" + operator + ", operation="
				+ operation + "]";
	}

    
}
