package com.wangrui.iocaop.ioc;

public class People {

	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public People() {
		
	}

	public People(Car car) {
		this.car = car;
	}
	
	
}
