package com.wangrui.javaadvance.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListAndImplemet {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		
		list.add("hello");
		list.add(0, "hi");
		list.add("!");
		list.add("!");
		list.add("!");
		
		System.out.println(list);
		
		
		List<String> list2 = new ArrayList();
		list2.add("...");
		list2.add("ok");
		list2.add("hi");
		
		list.addAll(list2); // list =  list U list2
		System.out.println(list);
		
		
		
	}
}
