package com.wangrui.iocaop.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class PeopleTest extends TestCase {

   private People people;
  	
	public PeopleTest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		this.people = (People) app.getBean("people");
		
	}
	
	public void testToString() {
		String b = people.getCar().getBrand();
		System.out.println(" brand:  "+b);
		people.getCar().run();
	}

}
