package com.wangrui.ioc_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "people")
@Scope("prototype")
public class People {

	@Value("小张")
	private String name;
	
	@Value("22")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
	
	
}
