package com.wangrui.ioc.anno;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car {

	@Value("QQ")
	private String brand = "QQ1";
	
	public Car(String brand) {
		this.brand = brand;
	}
	
	public Car() {
		this.brand = "QQ2";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void run() {
		System.out.println(this.brand + " run .........");
	}
}
