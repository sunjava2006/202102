package com.wangrui.tsd.bean;

import java.io.Serializable;
import java.sql.Date;

public class Recomment implements Serializable{

	private Integer recommentID;
	private Integer knowledgeID;
	private User user;
	private String content;
	private String grad;
	private Date publishDate;

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Integer getRecommentID() {
		return recommentID;
	}

	public void setRecommentID(Integer recommentID) {
		this.recommentID = recommentID;
	}

	public Integer getKnowledgeID() {
		return knowledgeID;
	}

	public void setKnowledgeID(Integer knowledgeID) {
		this.knowledgeID = knowledgeID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public Recomment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recomment(Integer recommentID, Integer knowledgeID, User user, String content, String grad) {
		super();
		this.recommentID = recommentID;
		this.knowledgeID = knowledgeID;
		this.user = user;
		this.content = content;
		this.grad = grad;
	}

	@Override
	public String toString() {
		return "Recomment [recommentID=" + recommentID + ", knowledgeID=" + knowledgeID + ", user=" + user
				+ ", content=" + content + ", grad=" + grad + "]";
	}

}
