package com.wangrui.base.usualy;

public class StringCreate {

	public static void main(String[] args) {
		String str = "hello";
		String str2 = "world";
		String str3 = "hello";
		
		System.out.println("str == str3 ? " + (str == str3));
		
		String str4 = new String("hello");
		System.out.println("str == str4 ? " + (str == str4));
		
		String str5 = new String("hello");
		System.out.println("str5 == str4 ? " + (str5 == str4));
		
		String str6 = new String("hi");// 创建了两个字符串对象，一个在常量池中，一个在堆中。
		String sgt7 = str6;
		
		String ss = "hi!"; // 
		str6 = str6+"!";
		System.out.println(str6);
		System.out.println(ss==str6);
		
//		str += "!";
//		System.out.println(str);
//		System.out.println(str3);
	}
}
