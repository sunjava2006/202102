package com.wangrui.base.flow;

public class Switch {

	public static void main(String[] args) {
		int ran = (int)(Math.random()*10);// 0-10֮�����
	    
		switch (String.valueOf(ran)) {   // int String enum
		default:
			System.out.println("1��2��3�������: "+ran);
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
		
		// switch case ����������int String enum
		// default ����case��������������switch���κ�λ�á�
		// ��û��break��������£������ҵ���ں󣬻�һֱ����ִ�С�
		
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
		
		if(season==Season.SPRING); // boolean ����
	}
	
}
