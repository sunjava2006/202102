package com.wangrui.javaadvance.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		
		Set<Integer> set = new HashSet<>();
		
		set.add(3);
		set.add(10);
		set.add(33);
		set.add(50);
		set.add(50);
		
		System.out.println(set.size());
		System.out.println(set);
		
		
		Iterator<Integer> iter = set.iterator(); // 只能通过迭代器来遍历元素
		
		while(iter.hasNext()) {
			Integer e = iter.next();
			System.out.println(e);
			if(e==3) {
				iter.remove();
			}
		}
		
		System.out.println("----------------------------------");
		// 隐式的使用迭代器   
		for(Integer i : set) {   // for eatch 只能用于Iterater接口和数组
			System.out.println(i);
		}
		
	}
}
