package com.thzhima.base.array;

import java.util.Arrays;

public class ArrayDemo1 {
    int[] a; // a = null;会缺省初始化。对象初始化为null。
    
    {
    	System.out.println(a);
    }
    
	public static void main(String[] args) {
		// 申明一个数组
		int[] a = null;  // 推荐的方式 
		int b[];  // c语言是一样的。局部变量，不会缺省初始化。必须显式进行初始化。
		System.out.println(a);
		
		b = new int[3]; // 创建一个长度为3的int类型数组
		boolean[] barr = new boolean[3]; // 申明并创建一个 boolean类型的数组对象，长度为3。
		Object[] objArr = new Object[4]; // 申明并创建一个Object类型的数组对象，长度为4。
		
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(barr));
		System.out.println(Arrays.toString(objArr));
		
		b[0] = 10;
		b[1] = 20;
		b[2] = 30;
		System.out.println(Arrays.toString(b));
		barr[0] = true;
		barr[2] = true;
		System.out.println(Arrays.toString(barr));
		objArr[0] = "hello";
		objArr[1] = new Object();
		objArr[2] = b;
		System.out.println(Arrays.toString(objArr));
	}
}
