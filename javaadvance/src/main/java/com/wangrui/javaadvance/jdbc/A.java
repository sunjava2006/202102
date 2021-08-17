package com.wangrui.javaadvance.jdbc;

public class A {
	static {
		System.out.println("==========static=============");
	}
	
	private int value ;
	public String name;
	
	public A() {
		System.out.println("constructor: A()");
	}
	
	public A(int v) {
		value = v;
	}

	@Override
	public String toString() {
		return "A [value=" + value + ", name=" + name + "]";
	}

	public void work(String task) {
		System.out.println("do " +  task);
	}
	
	public void work() {
		System.out.println("do work " );
	}
	
	
}
