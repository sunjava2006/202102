package com.thzhima.base.work;

public class ContinueDemo {

	public static void main(String[] args) {
		
		for(int i=1; i<=20; ) {
			
			int ran = (int)(Math.random()*100);
			if(0 == ran%2) {
				System.out.println("��⵽even: " + ran);
				continue;
			}
			System.out.println(ran);
			i++;
			
		}
		
		
		
	}

}
