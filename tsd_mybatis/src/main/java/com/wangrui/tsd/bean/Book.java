package com.wangrui.tsd.bean;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "book")
public class Book implements Serializable{

@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + "]";
	}
	//	@Value("Java入门")
//	@Value("${book.name}")
	private String name;
	
//	@Value("Smith")
//	@Value("${book.author}")
	private String author;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
