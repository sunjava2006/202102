package com.thzhima.base.array;

public class AccessArray {

	public static void main(String[] args) {
		String[] a = new String[3];
		
		a[0] = "I";
		a[1] = "like";
		a[2] = "java";
//		a[3] = "."; 索引超出数组的范围。起发运行时异常。
		
		System.out.println(a[0]);
		
		System.out.println("数组的长度是：" + a.length);
		
		for(int i=0; i<a.length; i++) {
			a[i] = a[i] + "!";
			System.out.println(i + ": "+ a[i]);
		}
		
		for(String s : a) {
			System.out.println(" : " + s);
		}
				
	}
}
