package com.thzhima.accessable.supered.supered;

public class A {

	int a;
}
class B extends A{
	int b;
}

class C extends B{
	
	{
		System.out.println(super.a);
	}
}