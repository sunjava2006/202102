package com.thzhima.wraper;

public class IntegerDemo2 {

	public static void main(String[] args) {
		
		
		Integer i = 127;
		Integer i2 = new Integer(127);
		Integer i3 = 127;
		
		System.out.println(i == i3);
		
		System.out.println("i == i2: " + (i == i2));
		
		Byte b = 127;
		Byte b2 = 127;
		System.out.println(b == b2);
		
		Short s = 127;
		Short s2 = 127;
		System.out.println(s == s2);
		
		Float f = 127F;
		Float f2 = 127F;
		System.out.println(f == f2);
		
		Boolean bb = true;
		Boolean bb2 = true;
		System.out.println(bb == bb2);
	}
}
