package com.wangrui.ioc_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student extends People{

	@Autowired(required = false) // 自动织入（按类型，同类型多个就按名字，没有同名就要指定名字）
	@Qualifier("java_Book") // 通过Bean的名字指定。
	private Book javaBook;

	
	public Book getBook() {
		return javaBook;
	}

	
	public void setBook(Book book) {
		this.javaBook = book;
	}
	
	
	
	
}
