package com.wangrui.tsd.bean;

public class User {

	private Integer userID;
	private String phoneNumber;
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserID() {
		return userID;
	}
	
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public User() {
		
	}

	public User(Integer userID, String phoneNumber) {
		this.userID = userID;
		this.phoneNumber = phoneNumber;
	}

	public User(Integer userID, String phoneNumber, String userName) {
		super();
		this.userID = userID;
		this.phoneNumber = phoneNumber;
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", phoneNumber=" + phoneNumber + ", userName=" + userName + "]";
	}

	
	
	
	
	
}
