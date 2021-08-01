package com.wangrui.base.array.test;

import java.util.Arrays;

public class Clone {

	public static void main(String[] args) {
		Book[] a = {new Book("a"), new Book("b"), new Book("c")};
		
		Book[] b = a.clone(); // 复制
		
		a[0].name = "d"; 
		System.out.println(a[0]);
		System.out.println(b[0]);
		
		//System.arraycopy
		Book[] c = new Book[10];
		System.arraycopy(a, 0, c, 0, 2); // 与clone相同，是浅复制。
		System.out.println(Arrays.toString(c));
		
		a[0].name = "java";
		System.out.println("c:"+Arrays.toString(c));
		
		// Arrays
		
		Book[] d = Arrays.copyOf(a, 2); // 与clone相同，是浅复制。
		System.out.println("d:"+Arrays.toString(d));
		a[0].name = "phthon";
		System.out.println("d:"+Arrays.toString(d));
		
		Book[] e = Arrays.copyOfRange(a, 1, 3); // 包含from  不包含to
		System.out.println("e:"+Arrays.toString(e));
		
		
	}
}
