package com.thzhima.advance.util;

import java.util.Hashtable;
import java.util.Map;

public class HashtableTest {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new Hashtable<>();//new HashMap<>();
		
		
		map.put("Mary", 0); // Hashtable key不可以为null。
		map.put("Jack", null);  // Hashtable value不可以为null。
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		
	}
}
