package com.wangrui.ioc_annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class StudentTest extends TestCase {

	Student s;
	
	public StudentTest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		s = app.getBean(Student.class);
		
	}
	
	public void test() {
		System.out.println(s.getBook().getName());
	}
}
