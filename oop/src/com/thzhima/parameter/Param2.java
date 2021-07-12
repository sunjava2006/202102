package com.thzhima.parameter;

public class Param2 {

	public void change(Human h) {
		h.age += 1;
	}
	
	
	public static void main(String[] args) {
		Param2 p = new Param2();
		Human h = new Human();
		
		p.change(h);
		System.out.println(h.age); // 1
	}
}

class Human{
	int age;
}
