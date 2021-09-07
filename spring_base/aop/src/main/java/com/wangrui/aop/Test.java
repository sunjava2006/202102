package com.wangrui.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.aop.dynamicproxy.PrintService;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		PrintService ps = (PrintService) app.getBean("print");
		
		ps.service("作业");
		
//		int r = ps.service2();
//		System.out.println(r);
		
	
	}
}
