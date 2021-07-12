package com.thzhima.inner;

public class Abs {

	public void run() {
		System.out.println("-------------------");
	}
	
	
	public static void main(String[] args) {
		Abs a = new Abs() {
//			@Override
//			public void run() {
//				System.out.println("================");
//			}
		};
		
		a.run();
		System.out.println(a.getClass().getName());
		System.out.println(a.getClass().getSuperclass().getName());
	}
}
