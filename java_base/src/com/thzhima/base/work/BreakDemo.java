package com.thzhima.base.work;

public class BreakDemo {

	public static void main(String[] args) {
		int count = 1;
		a: while(count<=3) {
			b: while(true) {
				int ran = (int)(Math.random()*10) % 2;
				
				System.out.println(ran);
				if( 0 == ran) {
					break a;
				}
			}
			
		}
		
		
		
	}
}
