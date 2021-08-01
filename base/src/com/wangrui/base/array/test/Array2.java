package com.wangrui.base.array.test;

public class Array2 {

	public static void main(String[] args) {
		int[][] a = new int[5][5];
		
		int v = 1;
		
		for(int i=0; i<a.length; i++) {
			for( int j=0;  j < a[i].length; j++) {
				a[i][j] = v++;
			}
		}
		
		for(int[] i : a) {
			for(int j : i) {
				System.out.print(j + ",");
			}
			System.out.println();
		}
		
		// ==================================
	}
}
