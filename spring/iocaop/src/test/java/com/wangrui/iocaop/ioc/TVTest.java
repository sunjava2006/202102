package com.wangrui.iocaop.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.iocaop.ioc.factory.TV;

import junit.framework.TestCase;

public class TVTest extends TestCase {
	TV tv;
	TV tv1;
	public TVTest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		tv = (TV) app.getBean("tv");
		tv1 = (TV) app.getBean("tv1");
		
	}
	
	public void testWatch() {
		tv.watch();
		tv1.watch();
	}
}
