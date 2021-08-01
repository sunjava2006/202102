package com.wangrui.base.flow.test;

public class FiBo {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 1;
		
		int sum = 0;
		
		for(;sum<5000;) {
			sum += b;
			System.out.println(b);
			int c = a+b;
			b = a;
			a = c;
		}
	}
}
