package com.wangrui.newfature.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OldOperation {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(200);
		list.add(300);
		list.add(50);
		list.add(80);
		
		// 只要想要数值>100的数据
		List<Integer> myList = new ArrayList<>();
		
		for(Integer i: list) {
			if(i>100) {
				myList.add(i);
			}
		}
		
		System.out.println(myList);
		
		
		//=======================================
		
		Stream<Integer> s = list.stream();
		
		
	   s=s.sorted((a, b)->{System.out.println("sorted:"+a+":" +b);return b-a;});
	   System.out.println("----------------");
	   s.forEach((i)->{System.out.println(i);});
				
				 // 流式代码风格
		
		
	}
}
