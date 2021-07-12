package com.wangrui.iocaop.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class CarTest extends TestCase {

	private Car car;
	
	public CarTest() {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		this.car = (Car) app.getBean("car1");
		Car car2 = (Car) app.getBean("car1");
		
		
		System.out.println(car == car2);
		
		System.out.println(car.getBrand());
		System.out.println(car.getSN());
	}
	
	public void testRun() {
		car.run();
	}

}
