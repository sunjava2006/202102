package com.wangrui.javaadvance.collection;

import java.util.concurrent.ConcurrentHashMap;

public class Concurrent {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>();
		
		chm.put("Peter", 1);
		chm.put("Mary", 4);
		chm.put("Jack", 3);
		chm.put("Will", 4);
		
		for(String key : chm.keySet()) {
			System.out.println(key + ":" + chm.get(key));
		}
	}
}
