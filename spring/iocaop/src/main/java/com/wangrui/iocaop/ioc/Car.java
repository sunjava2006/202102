package com.wangrui.iocaop.ioc;

public class Car {

	private String brand ;
	
	private String SN;
	
	public Car(String brand) {
		this.brand = brand;
	}
	
	public String getSN() {
		return SN;
	}

	public void setSN(String sN) {
		SN = sN;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	
	public void run() {
		System.out.println("开车..................");
	}
}
