package com.wangrui.newfature.generic;

import java.util.List;

public class GenericNot<T, V> {//extends Exception {
	
//	T t = new T();
//	T[] tarray = new T[20];
//	static public T o;
	T tt;
	V vv;
	
//	public void set(T t) { // 不可以使用泛型参数，实现方法重载
//		this.tt = t;
//	}
//	public void set(V v) {
//		this.vv = v;
//	}

	public static void main(String[] args) {
		
		List<Object> list = null;
		List<String> slist = null;
		
//		list = slist; // 泛型之间没有继承关系
		
		String s = null;
		Object o = null;
		o = s;
		
		
		//=============================
		GenericNot<String , String> gn = new GenericNot<>();
	}
}
