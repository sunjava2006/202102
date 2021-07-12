package com.wangrui.ioc_annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class PeopleTest extends TestCase {
	
	People p;
	public PeopleTest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		p = (People) app.getBean("people");
		People p2 = (People) app.getBean("people");
		System.out.println(p == p2);
	}
	
	
	public void testToString() {
	
		System.out.println(p);
	}

}
