package com.thzhima.advance.util;

import java.util.Hashtable;
import java.util.Map;

public class HashtableTest {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new Hashtable<>();//new HashMap<>();
		
		
		map.put("Mary", 0); // Hashtable key������Ϊnull��
		map.put("Jack", null);  // Hashtable value������Ϊnull��
		
		System.out.println(map.keySet());
		System.out.println(map.values());
		
		
	}
}
