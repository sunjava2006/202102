package com.thzhima.base.array.demo;

import java.util.Arrays;

public class CloneDemo {

	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int[] b = a.clone();

		Human h = new Human();
		h.name="小张";
		Human h2 = new Human();
		h2.name="小黄";
		
		Human[] array = new Human[]{h, h2};
		Human[] array2 = array.clone();
		
		array[0].name = "小王";
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array2));
	}
}

class Human{
	String name;
	
	public String toString() {
		return this.name;
	}
}
