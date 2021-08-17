package com.wangrui.javaadvance.collection;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		
		SortedMap<String , Integer> sm = new TreeMap<>((a, b)->b.compareToIgnoreCase(a));
		
		sm.put("Peter", 1);
		sm.put("Mary", 4);
		sm.put("Jack", 3);
		sm.put("Will", 4);
		
		for(String key : sm.keySet()) {
			System.out.println(key + ":" + sm.get(key));
		}
	}
}
