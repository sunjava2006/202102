package com.wangrui.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.ioc.methodInjection.Father;

public class TestIoc {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		GirlFriend gf = (GirlFriend) app.getBean("xiaoFang");
		
		System.out.println(gf);
		
		Boy boy = (Boy) app.getBean("boy");
		boy.marry();
		
		Father f = app.getBean(Father.class);
		GirlFriend fgf = f.see();
		System.out.println("爸爸给介绍的女朋友： "+fgf);
		
		System.out.println(f.getClass().getName());
		
		f.run("南京-北京");
	}
}
