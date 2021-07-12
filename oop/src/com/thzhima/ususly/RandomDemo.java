package com.thzhima.ususly;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		System.out.println(Math.random());
		
		
		Random r = new Random();
		
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		System.out.println(r.nextInt());
		
	}
}
