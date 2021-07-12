package com.thzhima.designmodel;

public class CarFactory {
	
//	private static CarFactory factory = new CarFactory(); // ����ģʽ eager
	private static CarFactory factory ;  // ����ģʽ lazy
	
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
