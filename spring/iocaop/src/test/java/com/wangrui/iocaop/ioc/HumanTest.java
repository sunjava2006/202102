package com.wangrui.iocaop.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class HumanTest extends TestCase {

	Human h;
	public HumanTest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		h = app.getBean(Human.class);
		System.out.println(h.getClass().getName());
	}
	
	public void testPlay() {
		h.play();
		h.todo();
	}

}
