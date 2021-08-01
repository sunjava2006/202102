package com.wangrui.base.type;

public class BaseTypeConvert {
	
	static short s ; // 类中定义的变量会缺省初始化。数值类型都为0，boolean为false。对象都为null。
	
	static String str;

	public static void main(String[] args) {
		int a = -129;
		byte b = (byte) a;
		System.out.println(b);
		
		float f = 20000999999999999L;
		System.out.println(f);
		
		
	    long l = 0;
	    System.out.println(l);
	    
	    
	    System.out.println(s);
	    
	    System.out.println(str);
	    
	    String s ; // 方法中定义的变量称，局部变量。局部变量不会缺省初始化。必须手动初始化。
//	    System.out.println(s);
	}
}
