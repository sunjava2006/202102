package com.thzhima.designmodel;

public class FactoryBuilder {

	public static Factory brildFactory( String bran){
		
		return new Factory() {
			final String brand = bran;
			
			@Override
			public Car createCar() {
				return new Car() {};
			}
			
		};
		
	}
}
