package com.wangrui.tsd.bean;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable{

	private Integer userID;
	private String phoneNumber;
	private String userName;
	private String avatarUrl;
    private List<Dynamic> dynamicList; // 对多的关联映射
	
    
    
	public List<Dynamic> getDynamicList() {
		return dynamicList;
	}

	public void setDynamicList(List<Dynamic> dynamicList) {
		this.dynamicList = dynamicList;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

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
		return "User [userID=" + userID + ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", avatarUrl="
				+ avatarUrl + ", dynamicList=" + dynamicList + "]";
	}

	

	

	
	
	
	
	
}
