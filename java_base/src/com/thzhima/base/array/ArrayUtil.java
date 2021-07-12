package com.thzhima.base.array;

import java.util.Arrays;

public class ArrayUtil {

	/**
	 * ��ѯn������array�г����ڴ�����
	 * @param array
	 * @param n
	 * @return ���n����array�з���0�����򷵻س��ֵĴ�����
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
	 * ��ת�����е�Ԫ�ء�[1,2,3,4,5]��תΪ[5,4,3,2,1]
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
