package com.wangrui.ioc.anno;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("anapp.xml");
//		Car car = (Car) app.getBean("car");
//		car.run();
//		System.out.println("------------------------------");
//		People li = (People) app.getBean("LiDog2");
//		
//		System.out.println(li.getName());
//		li.getCar().run();
//		
//		Car car2 = (Car) app.getBean("car");
//		
//		System.out.println(car == car2);
		
		PrintService ps = app.getBean(PrintService.class);
		ps.print();
		
		app.close();
	}
}
