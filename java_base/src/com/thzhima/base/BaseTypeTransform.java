package com.thzhima.base;

public class BaseTypeTransform {

	public static void main(String[] args) {
		
		byte b = 4;  // 8
		
		int i = b; // 32  隐式类型转换。
		
		short s = (short)i;  // 16 强制类型转换。
		
		float f = 3.14f;
		
		double d = f;
		
		f = (float) d;
		
		int a  = 'a';
		char c = 300;
		
		float f2 = 2076767676767676760L;
		System.out.println(f2);
		
		float ff  =  22.34665656E3F;
		
		System.out.println(ff);
	}
}
