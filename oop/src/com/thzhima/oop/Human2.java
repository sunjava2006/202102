package com.thzhima.oop;

public class Human2 {

	String name;
	final String gender ;
	
	{
//		this.gender = "";
	}
	
	Human2(String gender){
		this.gender = gender;
	}
	
	
	public static void main(String[] args) {
		final Human2 h = new Human2("ÄÐ");
		
		h.name = "wang";
		
	}
}
