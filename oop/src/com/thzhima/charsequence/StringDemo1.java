package com.thzhima.charsequence;

public class StringDemo1 {

	public static void main(String[] args) {
		
		String str = "hello"; // 在虚拟器的方法区的常量池中创建"hello"字符串对象。、
		String str3 = "hello"; // 只要字符串的值是相同的，就从常量池中取同一个对象赋给变量。
		String str4 = "world";  // 只要常量池中没有指定的值，就新建一个存储在常量池中。
		
		System.out.println(str == str4);
		
		System.out.println(str == str3);
		
		System.out.println("str == 'hello': " + (str == "hello"));
		
		
		// new就会创建一个新对象，并使用指定构造初始化。new的过程中，参数与新对象是两个对象。
		String str2 = new String("hello"); 
		System.out.println("str2 == str : "+ (str2 == str));
		
		String str5 = new String("hello");
		System.out.println("str2 == str5 : "+ (str2 == str5));

		String str6 = new String("hi"); // "hi"在常量池，str6引用的对象在堆上。
		
		
		
	}
}
