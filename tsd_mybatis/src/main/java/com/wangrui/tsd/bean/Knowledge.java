package com.wangrui.tsd.bean;

import java.io.Serializable;

// 要缓存的对象必须实现序列化接口
public class Knowledge implements Serializable{

	private Integer knowledgeID;
	private String abs;
	private String content;
	private String picture;
	private User user; // 对一的对象关联映射
	private Recomment lastRecomment;

	public Recomment getLastRecomment() {
		return lastRecomment;
	}

	public void setLastRecomment(Recomment lastRecomment) {
		this.lastRecomment = lastRecomment;
	}

	public Integer getKnowledgeID() {
		return knowledgeID;
	}

	public void setKnowledgeID(Integer knowledgeID) {
		this.knowledgeID = knowledgeID;
	}

	public String getAbs() {
		return abs;
	}

	public void setAbs(String abs) {
		this.abs = abs;
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

	public Knowledge(Integer knowledgeID, String abs, String content, String picture, User user) {
		super();
		this.knowledgeID = knowledgeID;
		this.abs = abs;
		this.content = content;
		this.picture = picture;
		this.user = user;
	}

	public Knowledge() {
		
	}

	@Override
	public String toString() {
		return "Knowledge [knowledgeID=" + knowledgeID + ", abs=" + abs + ", content=" + content + ", picture="
				+ picture + ", user=" + user + ", lastRecomment=" + lastRecomment + "]";
	}

	
	
	

}
