package com.thzhima.accessable;

import com.thzhima.accessable.aaaa.C;

public class B {

	public void aboutA() {
		A a = new A();
		
		System.out.println(a.a+a.b+a.c);
	}
	
	public static void main(String[] args) {
		A a = new C();
		
		a.b();
		a.c();
	}
}
