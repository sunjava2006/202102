package com.wangrui.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class ReportServiceTest extends TestCase {

	ReportService rs;
	
	public ReportServiceTest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		rs = app.getBean(ReportService.class);
	}
	
	public void testService() {
		rs.service();
	}

}
