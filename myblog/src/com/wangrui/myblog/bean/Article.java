package com.wangrui.myblog.bean;

import java.sql.Date;

public class Article {

	private int articleID;
	private int blogID;
	private String title;
	private String content;
	private Date publishDate;
	private int accessCount;
	private int typeID;
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public int getBlogID() {
		return blogID;
	}
	public void setBlogID(int blogID) {
		this.blogID = blogID;
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
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public int getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}
	public int getTypeID() {
		return typeID;
	}
	
	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}
	
	public Article(int articleID, int blogID, String title, String content, Date publishDate, int accessCount,
			int typeID) {
		super();
		this.articleID = articleID;
		this.blogID = blogID;
		this.title = title;
		this.content = content;
		this.publishDate = publishDate;
		this.accessCount = accessCount;
		this.typeID = typeID;
	}
	
	
	
}
