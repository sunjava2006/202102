package com.wangrui.base.flow;

public class follow {

	public static void main(String[] args) {

		double ran = Math.random() * 10;
		System.out.println(ran);

		if (ran <= 5) {
			System.out.println("================");
			System.out.println("<=5");
			System.out.println("================");
		}else {
			System.out.println("----------------");
			System.out.println(">5");
			System.out.println("----------------");
		}

	}
}
