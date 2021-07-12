package com.thzhima.base.array;

public class Array2 {

	public static void main(String[] args) {
		/**
		  *  多维数组是数组的数组。
		  *  二维数组，就是在一维数组的基础上，每一个元素存放的也是一个数组。
		 *   将多维数组，元素之间的关系变成了嵌套的关系。
		 */
		int[][] a;
		a = new int[3][2]; // {{0,0},{0,0},{0,0}}
		/*
		 *{{10,20},{30,40},{50,60}} 
		 */
		a[0][0] = 10;
		a[0][1] = 20;
		a[1][0] = 30;
		a[1][1] = 40;
		a[2][0] = 50;
		a[2][1] = 60;
		
		for(int i=0; i<a.length; i++) {
			int[] e = a[i];
			for(int j=0; j<e.length; j++) {
				System.out.print(e[j] + " \t");
			}
			System.out.println();
		}
		
		for(int [] e : a) {
			for( int i : e) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
		
		int[][] b = new int[2][]; // {null, null}
		System.out.println(b[0]);
		b[0] = new int[2]; // {{0, 0}, null}
		b[1] = new int[]{3,4,5}; // {{0, 0}, {3, 4, 5}}
		
		for(int[] e : b) {
			for(int i : e) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
		
		
		int[][] c = new int[][] {{1},{2,3}};
		
		
	}
}
