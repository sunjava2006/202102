package com.wangrui.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class PrintServiceTest extends TestCase {
	
	PrintService ps;
	
	public PrintServiceTest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		ps = app.getBean(PrintService.class);
	}

	public void testInit() {
//		ps.init();
	}

	public void testService() {
		ps.service();
	}

}
