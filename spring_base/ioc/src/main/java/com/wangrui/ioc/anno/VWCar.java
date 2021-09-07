package com.wangrui.ioc.anno;

import org.springframework.stereotype.Component;

@Component
public class VWCar extends Car{

	
	public VWCar() {
		
		super("vW");
		System.out.println("public VWCar() " + this.getBrand());
	}
}
