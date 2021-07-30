package com.wangrui.tsd.bean;

import java.io.Serializable;

public class Admin implements Serializable{

	private Integer ID;
	private String loginName;
	private String pwd;

	public Admin(Integer iD, String loginName, String pwd) {
		super();
		ID = iD;
		this.loginName = loginName;
		this.pwd = pwd;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Admin [ID=" + ID + ", loginName=" + loginName + ", pwd=" + pwd + "]";
	}

}
