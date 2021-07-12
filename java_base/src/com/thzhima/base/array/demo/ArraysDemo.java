package com.thzhima.base.array.demo;

import java.util.Arrays;

public class ArraysDemo {

	public static void main(String[] args) {
	    int[] a = {12,4,16,8};
	    
	    Arrays.sort(a);
	    /** binarySearch是二分查找法， 必须先排序。
	     *   1234 5 6789
	     */
	    int at4 = Arrays.binarySearch(a, 8);
	    System.out.println(at4);
	    
	    System.out.println(Arrays.toString(a));
	    
	    Arrays.fill(a, 90);
	    System.out.println(Arrays.toString(a));
	}

}
