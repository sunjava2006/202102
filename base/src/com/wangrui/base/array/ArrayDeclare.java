package com.wangrui.base.array;

import java.util.Arrays;

public class ArrayDeclare {

	public static void main(String[] args) {
		
		int a[] = new int[3]; // 定义一个长度为3的整型数组。
		//        [0, 0, 0]
		
		boolean[] b = new boolean[3];
		//            [false, false, false]
		
		String[] s = new String[3];
		//           [null, null, null]
		
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(s));
		
		a[0] = 10;
		a[1] = 20;
		a[2] = 30;
		System.out.println(Arrays.toString(a));
		
		//================================================
		int[] c = {100, 200, 300};  // 静态初始化,必须与申明一同使用。
		System.out.println(Arrays.toString(c));
		
		int[] d = new int[] {1000, 2000, 3000}; // 有初始化数据，就不能指定数组长度。数组的长度就是初始数据的大小。
		System.out.println(Arrays.toString(d));
		
		
		int[] e;
		e = new int[]{};
	}
}
