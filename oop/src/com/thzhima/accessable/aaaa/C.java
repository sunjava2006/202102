package com.thzhima.accessable.aaaa;

import com.thzhima.accessable.A;

public class C extends A{

	public void about() {
		System.out.println(this.a+this.b);
	}
	
//	@Override
	public void c() {
		System.out.println("--------------");
	}
	
//	@Override
	public void d() {
		System.out.println("================");
	}
	
	public static void main(String[] args) {
		A a = new C();
		
		
	}
}
