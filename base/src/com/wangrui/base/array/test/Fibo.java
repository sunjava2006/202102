package com.wangrui.base.array.test;

import java.util.Arrays;

public class Fibo {

	public static void main(String[] args) {
		
		
		int[] a = new int[10];
		a[0] = 1;
		a[1] = 1;
		
		for(int i = 2; i < a.length; i++) {
			a[i] = a[i-1] + a[i-2];
		}
		System.out.println("a:" + Arrays.toString(a));
		
		// 数组的复制
		// clone
		int[] b = a.clone();  // 是对当前对象的浅度复制。
		System.out.println("b:" + Arrays.toString(b));
		System.out.println("a==b: " + (a == b)); // 对象之间==比较，比较的是地址。
		
		int[] c = a;
		System.out.println("c:"+Arrays.toString(c));
		System.out.println("a==c:" + (a==c));
		// Arrays
		// System
		
		
	}
}
