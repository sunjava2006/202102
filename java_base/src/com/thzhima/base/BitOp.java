package com.thzhima.base;

public class BitOp {

	public static void main(String[] args) {
//		按位与运算符（&），两个二进制数，按位对齐，只有该位上都为1时，才为1。
//		按位或运算符（|），两个二进制数，按位对齐，其中只要一个为1，就为1。
//		按位异或运算符（^），两个二进制数，按位对齐，该位是两数不同，就为1。
//		按位取反运算符（~）. 单目运算。0为1，1为0。
//		左移位运算符（<<）和右移位运算符（>>）。
		
		/**
		  * 位运算是二进制数据的运算。
		 */
		int a = 10;  // 0 0 0 0 1 0 1 0  =>10
		int b = 6;   // 0 0 0 0 0 1 1 0
		
		System.out.println(  a & b ); // 0 0 0 0 0 0 1 0
		System.out.println( a | b );  // 0 0 0 0 1 1 1 0
		System.out.println( a ^ b );  // 0 0 0 0 1 1 0 0 
		System.out.println( ~a );     //1... 1 1 1 1 0 1 0 1 => 0 0 0 0 1 0 1 1
		
		System.out.println(a << 28 );   //  0 0 0 1 0 1 0 0 =>20
		
		System.err.println(a >> 2);     //  0 0 0 0 0 0 1 0
		
		int c = -3;   // 0 0 0 0 0 0 1 1 -> 1... 1 1 1 1 1 1 0 1
		System.out.println(c >> 1);   // 1 1... 1 1 1 1 1 1 0 
		System.err.println(c >>> 1);  // 0 1... 1 1 1 1 1 1 0 
		
		
		 /**
		  *   2 - 2  == 2 + (-2)
		  *   
		  *                 00000010
		  *   
		  *   11111101+1 == 11111110
		  *   
		  *   
		  *               1,00000000 
		  *   
		  */
 
	}
}
