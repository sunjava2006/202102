package com.wangrui.ioc_annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class ServiceATest extends TestCase {

	ServiceA s;
	 ClassPathXmlApplicationContext app;
	public ServiceATest() {
	   app = new ClassPathXmlApplicationContext("app.xml");
	   s = app.getBean(ServiceA.class);
	}
	
	public void testService() {
		s.service();
		app.destroy();
		
	}

}
