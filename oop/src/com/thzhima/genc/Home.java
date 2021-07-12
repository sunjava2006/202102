package com.thzhima.genc;

public class Home<T> {

	T pat;
	
	public static void main(String[] args) {
		Home<Cat> home1 = new Home<Cat>();
		Home<Dog> home2 = new Home<>();
		
		home1.pat = new Cat();
		home2.pat = new Dog();
		
		Home home3 = new Home();
		home3.pat = new Dog();
	}
}
