package com.wangrui.base.type;

import java.util.List;

public class Op2 {

	public static boolean a() {
		System.out.println("a");
		return true;
	}
	
	public static boolean b() {
		System.out.println("b");
		return false;
	}
	
	public static void main(String[] args) {
		
		boolean r = a() || b();
		System.out.println("===========================");
		r = b() && a();
		
		int a = 1; // 0000001>>1    0000010
		
		System.out.println(a = a<<2);
		
		System.out.println(a>>2);
		
		System.out.println(a>>>2);
		
		// 1111000>>1
		// 1111100
		// 1111000>>>1
		// 0111100
		System.out.println(-10>>1);
		System.out.println(-10>>>1);
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		r = a() | b();
		System.out.println("r:"+r);
		
		r = b() & a();
		System.out.println("r:"+r);
		
		
		int x = 1==10 ? 20: 0;
		System.out.println(x);
		
		Object o = "hello";
		
		System.out.println(o instanceof String);
		System.out.println(o instanceof Object);
		System.out.println(o instanceof List);
		
	}
}
