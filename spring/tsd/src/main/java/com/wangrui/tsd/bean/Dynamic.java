package com.wangrui.tsd.bean;

public class Dynamic {

	private Integer dynamicID;
	private String title;
	private String content;
	private String picture;
	private User user; // Mybatis iBatis ORM

	public Integer getDynamicID() {
		return dynamicID;
	}

	public void setDynamicID(Integer dynamicID) {
		this.dynamicID = dynamicID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dynamic(Integer dynamicID, String title, String content, String picture, User user) {
		super();
		this.dynamicID = dynamicID;
		this.title = title;
		this.content = content;
		this.picture = picture;
		this.user = user;
	}

	public Dynamic() {

	}

	@Override
	public String toString() {
		return "Dynamic [dynamicID=" + dynamicID + ", title=" + title + ", content=" + content + ", picture=" + picture
				+ ", user=" + user + "]";
	}

}
