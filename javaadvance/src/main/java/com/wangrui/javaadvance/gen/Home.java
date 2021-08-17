package com.wangrui.javaadvance.gen;

// 泛型,类型参数（参量多态）
public class Home<T> {

	T pet;
	
	public static void main(String[] args) {
		Home<Dog> h = new Home<Dog>();
		h.pet = new Dog();
		
		
		Home<Cat> h2 = new Home<>();
		h2.pet = new Cat();
		
		
	}
}
