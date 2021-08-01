package com.wangrui.base.array.test;

import java.util.Arrays;

public class BubberSort {

	public static void main(String[] args) {
		int[] a = {3,8,1,0,5,9,4};
		
		for(int i=0;i<a.length-1; i++) {
			boolean change = false;
			for(int j=0; j<a.length-1-i ;j++) {
				if(a[j]>a[j+1]) {
					int t = a[j];
					a[j] = a[j+1];
					a[j+1] = t;
					change = true;
				}
			}
			if(!change) {
				break;
			}
		}
		
		System.out.println(Arrays.toString(a));
	}
}
