package com.thzhima.base;

public class ChoiceIf {
	
	{
		
	}

	public static void main(String[] args) {
		
		boolean rain  = Math.round(Math.random()*10)%2==0 ? true : false;
		System.out.println(rain);
		
		if(rain){
			System.out.println("??ɡ");
			System.out.println("????Ь");
		}else {
			System.out.println("-------------------");
			System.out.println("????С??Ь");
		}
		
		System.out.println("????");
		
	}
}
