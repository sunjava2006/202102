package com.wangrui.myblog.bean;

import java.io.Serializable;

public class Blog implements Serializable{

	private int blogID;
	private String blogName;
	private String nickName;
	private int userID;
	private String photo;
	
	public int getBlogID() {
		return blogID;
	}
	public void setBlogID(int blogID) {
		this.blogID = blogID;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Blog(int blogID, String blogName, String nickName, int userID, String photo) {
		super();
		this.blogID = blogID;
		this.blogName = blogName;
		this.nickName = nickName;
		this.userID = userID;
		this.photo = photo;
	}
	
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Blog [blogID=" + blogID + ", blogName=" + blogName + ", nickName=" + nickName + ", userID=" + userID
				+ "]";
	}
	
	
}
