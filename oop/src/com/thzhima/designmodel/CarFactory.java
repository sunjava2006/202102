package com.thzhima.designmodel;

public class CarFactory {
	
//	private static CarFactory factory = new CarFactory(); // 饿汉模式 eager
	private static CarFactory factory ;  // 懒汉模式 lazy
	
	private CarFactory() {
		
	}
	
//	public static CarFactory getInstance() {
//		return factory;
//	}
	
	public static CarFactory getInstance() {
		if(factory == null) {
			factory =  new CarFactory();
		}
		return factory;
	}

	public Car createCar() {
		return new Car() {};
	}
	
	
}
