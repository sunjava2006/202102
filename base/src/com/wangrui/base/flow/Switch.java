package com.wangrui.base.flow;

public class Switch {

	public static void main(String[] args) {
		int ran = (int)(Math.random()*10);// 0-10之间的数
	    
		switch (String.valueOf(ran)) {   // int String enum
		default:
			System.out.println("1、2、3以外的数: "+ran);
//		break;
		case "1":
			System.out.println("is 1");
//			break;
		
		case "2":
			System.out.println("is 2");
//			break;
		case "3":
			System.out.println("is 3");
			break;
		
		}
		
		// switch case 的数据类型int String enum
		// default 不是case的子名，可以在switch中任何位置。
		// 在没有break语句的情况下，流程找到入口后，会一直向下执行。
		
		Season season = Season.AUTUMN;
		
		switch(season) {
		case SPRING:
			System.out.println("SPRING");
			break;
		case SUMMER:
			System.out.println("summer");
			break;
		case AUTUMN:
			System.out.println("autumn");
		    break;
		case WINTER:
			System.out.println("winter");
		}
		
		if(season==Season.SPRING); // boolean 类型
	}
	
}
