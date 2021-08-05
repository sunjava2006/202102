package com.wangrui.base.inherit;

public class Human {

	public String name;
	public String gender;
	public int age;
	
	public Human() {
		
	}
	
	public Human(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}

	public void sing() {
		System.out.println("����");
	}
	
	public void dance() {
		System.out.println("����");
	}
}
