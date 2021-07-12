package com.wangrui.ioc_annotation;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class LibraryTest extends TestCase {

	Library lib;
	
	public LibraryTest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		lib = app.getBean(Library.class);
		
	}
	
	
	public void testGetBookList() {
	   List<Book> list = lib.getBookList()	;
	   System.out.println(list);
	}

}
