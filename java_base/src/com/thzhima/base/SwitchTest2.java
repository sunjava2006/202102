package com.thzhima.base;

public class SwitchTest2 {

	public static void main(String[] args) {
		
		Season s = null;
		
		int a = (int)(Math.random()*100) % 4;
		
		switch(a) {
		default :
			s = Season.WINTER;
			break;
		case 0:
			s = Season.SPRING;
			break;
		case 1:
			s = Season.SUMMER;
			break;
		
		case 2:
			s = Season.AUTUMN;
			break;
		}
		
		switch(s) {
		case SPRING:
		    System.out.println("春天");
		    break;
		case SUMMER:
			System.out.println("夏天");
			break;
		case AUTUMN:
			System.out.println("秋天");
			break;
		case WINTER:
			System.out.println("冬天");
			break;
		default:
			System.out.println("不是本地的季节");
				
		}
		
		System.out.println(a + ":" + s);
		
		
	}
}
