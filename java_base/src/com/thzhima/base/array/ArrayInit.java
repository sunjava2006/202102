package com.thzhima.base.array;

public class ArrayInit {

	public static void main(String[] args) {
		int[] a = new int[3];  // [0, 0, 0]
		int[] b = new int[] {10, 20, 30}; // [10, 20, 30] 长度为初始值确定的长度。
		int[] c = {100, 200, 300, 400}; // 静态初始化
		
		int[] d ;
//		d = {1, 2, 3};
		// 只要有初始值，就只能按初始值来创建数组对象。[长度]不能指定。
		d = new int[] {100, 200, 300}; 
	}
}
