package com.wangrui.base.array;

public class Array2 {

	public static void main(String[] args) {
		int[][] a = new int[3][2];
		
		// {{0, 0},{0, 0},{0, 0}}
		
		System.out.println("a.length:"+a.length);
		
		for(int[] i : a) {
			System.out.println(i.length);
		}
		
		a[0][0] = 1;
		a[0][1] = 2;
		// {{1, 2},{0, 0},{0, 0}}
		System.out.println("==========================");
		
		int[][] b = new int[][] {{1,2},{3,4,5},{6}};
		for(int[] i : b ) {
//			System.out.println(i.length);
			for(int j : i) {
				System.out.print(j + ",");
			}
			System.out.println();
		}
		
		int[][] c = new int[3][];
		
		c[0] = new int[1];
		c[1] = new int[4];
		c[2] = new int[] {3,4,5};
		System.out.println("=================================");
		for(int [] i : c) {
			for(int j : i) {
				System.out.print(j +",");
			}
			System.out.println();
		}
	}
}
