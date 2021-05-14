package com.thzhima.base;

public class Local {

	int c = 90; // 成员变量
	int i = 0;
	
	public int add(int a, int b) {
		int c = a+b;
		
		{
			int d = 0;
//			int c = 0;
			c += d;
			c += i;
			
		}
//		c -= d;
		
		return c;
	}
	
	int k = i;
	
}
