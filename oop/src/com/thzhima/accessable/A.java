package com.thzhima.accessable;

public class A {

	public int a ;
	protected int b;
	int c;
	private int d;
	
	public void about() {
		System.out.println(this.a+this.b+this.c+this.d);
	}
	
	protected void b() {
		System.out.println("************");
	}
	
	void c() {
		System.out.println("************");
	}
	
	private void d() {
		
	}
	
	
}
