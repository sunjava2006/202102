package com.thzhima.base;

public class LogicTest {

	
	public static boolean a() {
		System.out.println("a");
		return true;
	}
	
	public static boolean b() {
		System.out.println("b");
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		int a = 1;
		
		boolean agt = a > 10;
		System.out.println(agt);
		
		
		// “！”逻辑非运算符， 单目运算。
		System.out.println(!agt);
		
		System.out.println(!true);
		System.out.println(!false);
		
		//  "逻辑与"，并且运算符。是一个双目运算。只有两个操作数，都为true。才返回true。
		int b = 20;
		System.out.println("a<10  && b>10  :" + ( a<10  && b>10 ));
		System.out.println("a>10  && b>10  :" + ( a>10  && b>10 ));
		
		// “逻辑或”，或者运算。是双目运算。两个操作数，其中一个为true, 就返回true。
		System.out.println("a>10 || b>10 : " + ( a>10 || b>10));
		System.out.println("a<10 || b>10 : " + ( a<10 || b>10));
		System.out.println("a>10 || b<10 : " + ( a>10 || b<10));
		
		// && || 具有短路效应（走捷径）
		/*  
		 *   a=>false &&  b
		 * 
		 *   a=>true || b
		 * */
		
		boolean k = b() && a (); // 第一个条件为false。
		System.out.println("=========================");
		
		k = a() || b(); // 第一个条件为true。
		
		
	}
}
