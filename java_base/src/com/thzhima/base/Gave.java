package com.thzhima.base;

import java.util.List;

public class Gave {

	public static void main(String[] args) {
		int a = 90;
		
		a += 90; // a = a + 90;
		
		a <<= 1; // a =  a << 1;
		
		int b = 1>10 ? 10 : 0;
		System.out.println(b);
		
		
		String s =  "china";
		
		Object str = s;
		
		System.out.println(str instanceof String);
		System.out.println(str instanceof List);
		System.out.println(str instanceof Object);
	}
}
