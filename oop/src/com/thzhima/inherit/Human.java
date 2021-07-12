package com.thzhima.inherit;

public class Human {

	public static String country = "china";
	protected String name;
	public final String gender;
	
	{
		System.out.println();
	}
	
	Human(){
		System.out.println("------Human()-------");
		this.gender = "ƒ– ";
	}
	
	Human(String gender, String name){
		System.out.println("---------Human(String gender, String name)----------");
		this.gender = gender;
		this.name = name;
	}
	
	public void work() {
		System.out.println(this.name + " working now.");
	}
	
	public static void shootSun() {
		System.out.println("…‰»’");
	}
}
