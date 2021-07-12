package com.thzhima.parameter;

public class Param1 {

	int sum(int a, int b) {
		
		int c = a + b;
		
		return c;
	}
	
	void change(int a) {
		a = a+90;

	}
	
	
	
	public static void main(String[] args) {
		Param1 p = new Param1();
		
		int a = 10;
		int b = 1;
		
		int result = p.sum(a, b);
		System.out.println(result);
		
		
		p.change(a);
		System.out.println(a);  // 10
		
	}
	
}
