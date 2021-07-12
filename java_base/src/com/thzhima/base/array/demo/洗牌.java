package com.thzhima.base.array.demo;

import java.util.Arrays;

public class 洗牌 {

	public static void main(String[] args) {
		/*
		 * 有8张牌，从中一分为二，进行洗牌。问洗多少次后，与原始順序相同。
		 * 
		 * 1,2,3,4,            5,6,7,8
		 * 1,5,2,6,            3,7,4,8
		 * 1,3,5,7,             2,4,6,8,
		 * 1,2,3,4,5,6,7,8
		 * 
		 */
		
		 int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
		 int[] copy = a.clone();
		 int count=0;
		 do {
			 // 将a数组中的内容从中分开，到两个小数组中。
			 int[] left = new int[4];
			 int[] right = new int[4];
			 left = Arrays.copyOf(a, 4);
			 right = Arrays.copyOfRange(a, 4, 8);
			 
			 
			 // 再将两个小数组中的元素，交替覆盖到a数组中。
			 /*
			  * 
			  */
			 for(int i=0; i<left.length; i++) {
				 a[i*2] = left[i];
				 a[i*2+1] = right[i];
			 }
			 count++;
			 
		 }while(!Arrays.equals(a, copy));
		 
		System.out.println(count);
		
		int[] i = {20,30, 40, 50};
		int[] j = new int[20];
		System.arraycopy(i, 1, j, 4, 2);
		System.out.println(Arrays.toString(j));
	}
}
