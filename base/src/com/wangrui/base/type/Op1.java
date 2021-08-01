package com.wangrui.base.type;

public class Op1 {

	public static void main(String[] args) {
		
		System.out.println( 3 / 2d );
		System.out.println(3 % 2d);
		System.out.println(2*3f);
		
		int a = 1;
		int b = a++;
		
		System.out.println(b);
		System.out.println(a);
		
		b = ++a;
		System.out.println(b);//3
		System.out.println(a);//3
		
		a = ++a; // 4
		System.out.println(a);
		
		a = a++; // 4
		
		boolean f = false;
		System.out.println(!f);
		System.out.println(!true);
		
		System.out.println(false || false); // ªÚ’ﬂ
		System.out.println(false && true);  // ≤¢«“
		
	}
	
}
