package com.wangrui.javaadvance.jdbc.bean;


public class User{

	private int userID;
	private String loginName;
	private String pwd;
	private String gender;
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", loginName=" + loginName + ", pwd=" + pwd + ", gender=" + gender + "]";
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userID, String loginName, String pwd, String gender) {
		super();
		this.userID = userID;
		this.loginName = loginName;
		this.pwd = pwd;
		this.gender = gender;
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((loginName == null) ? 0 : loginName.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + userID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (loginName == null) {
			if (other.loginName != null)
				return false;
		} else if (!loginName.equals(other.loginName))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	
	
	
}
