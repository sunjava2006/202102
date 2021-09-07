package com.wangrui.ioc.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wangrui.ioc.propinjection.Library;

public class Test {

	public static void main(String[] args) {
		 // 实例工厂模式,对象由第三方提供
		CarFactory carfactory = new CarFactory();
		
		Car car = carfactory.createCar();
		
		car.run();
		//==========================================
		// 静态工厂模式
		car = AutoCarFactory.createCar();
		car.run();
		
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		Car car2 = (Car) app.getBean("car");
		car2.run();
		
		Car car3 = (Car) app.getBean("autoCar");
		car3.run();
		
		
		Library lib = app.getBean(Library.class);
		System.out.println(lib.getBookNames());
		
		Car car4 = (Car) app.getBean("autoCar");
		
		System.out.println(car3 ==  car4);
	}
}
