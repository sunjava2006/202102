package com.thzhima.base.array.demo;

public class Array1 {

	public static void main(String[] args) {
		/*
		  *  一个5*5大小的数组，为其中元素赋值1-25。
		 */
		int[][] a = new int[5][5];
		int value = 1;
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = value++;
				System.out.print(a[i][j] + ",");
			}
			System.out.println();
		}
		
		int sum = 0;
		for(int i=0; i<a.length; i++) {
			sum += a[i][i];
		}
		System.out.println("sum: " + sum);
		
		sum = 0;
		for(int i=0, j=a[i].length-1; i<a.length; i++, j--) {
			sum += a[i][j];
		}
		System.out.println("sum: " + sum);
	}
}
