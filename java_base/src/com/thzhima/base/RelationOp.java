package com.thzhima.base;

public class RelationOp {

	public static void main(String[] args) {
		// 关系运算，是比较两数是否等与不等、大小之间的关系。运算的结果返回true或false。
		
		int a = 10, b = 20;
		
		boolean eq = a == b;
		System.out.println("a == b : " + eq);
		
		System.out.println("a < b : " + (a < b));
		
		System.out.println("a > b : " + (a > b));
		
		System.out.println("a <= b : " + (a <= b));
		
		System.out.println("a >= b : " + (a >= b));
		
		System.out.println("a != b : " + (a != b));
		
	}
}
