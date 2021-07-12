package com.thzhima.base.array;

import java.util.Arrays;

public class ArrayUtil {

	/**
	 * 查询n在数组array中出现在次数。
	 * @param array
	 * @param n
	 * @return 如果n不在array中返回0，否则返回出现的次数。
	 */
	public static int find(int[] array, int n) {
		int count = 0;
		for(int i : array) {
			if(i == n) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 返转数组中的元素。[1,2,3,4,5]反转为[5,4,3,2,1]
	 * @param array
	 */
	public static void reverse(int[] array) {
		int count = array.length/2;
		for(int i=0, j=array.length-1; i<count; i++, j--) {
			int t = array[i];
			array[i] = array[j];
			array[j] = t;
		}
	}
	
	public static void sort(int[] array, boolean asc) {
		for(int i=0; i<array.length-2; i++) {
			boolean change = false;
			for(int j=0; j<array.length-1-i; j++) {
				if(asc) {
					if(array[j]>array[j+1]) {
						int t = array[j];
						array[j] = array[j+1];
						array[j+1] = t;
						change = true;
					}
				}else {
					if(array[j]<array[j+1]) {
						int t = array[j];
						array[j] = array[j+1];
						array[j+1] = t;
						change = true;
					}
				}
				
			}
			if(!change) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {10, 12, 24, 20, 16, 18, 30, 20, 12, 12, 14, 12};
		
//		System.out.println(find(a, 12));
//		reverse(a);
//		System.out.println(Arrays.toString(a));
		
		sort(a, false);
		System.out.println(Arrays.toString(a));
		
	}
	
	
}
