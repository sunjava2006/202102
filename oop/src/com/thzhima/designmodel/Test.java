package com.thzhima.designmodel;

public class Test {

	public static void main(String[] args) {
		
//		Car car = new Car();
		
		CarFactory factory = CarFactory.getInstance();
		Car car2 = factory.createCar();
		
		
		CarFactory factory2 = CarFactory.getInstance();
		Car car3 = factory2.createCar();
		
		Car car4 = CarFactory2.creatCar();
		
		Factory f = FactoryBuilder.brildFactory("Audi");
		Car car5 = f.createCar();
	}
}
