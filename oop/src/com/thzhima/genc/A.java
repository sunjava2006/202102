package com.thzhima.genc;

public class A {

	static int aa = 0;
	int bb = 90;
	
	static class B{
		static int aa = A.aa;
		int bb = 90;
		
	}
	
	static class C{
		static  int aa = B.aa;
	}
	
	class D{
		int bb = A.this.bb;

	}
	
	
	public static void main(String[] args) {
		A.B b = new A.B();
	}
}
