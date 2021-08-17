package com.wangrui.javaadvance.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		
		Map<Integer, String> map =  new HashMap<>();
		
		map.put(1, "Jack");
		map.put(2, "Marry");
		map.put(30, "Peter");
		map.put(5, "Will");
		map.put(5, "David");
		map.put(null, null);
		
		System.out.println(map);
		
		
		String value = map.get(2);
		System.out.println(value);
		value = map.get(30);
		System.out.println(value);
		value = map.get(26);
		System.out.println(value);
		
		System.out.println("--------------------------------");
		Set<Integer> keySet = map.keySet();
		System.out.println(keySet);
		
		System.out.println("--------------------------------");
		Collection<String> values = map.values();
		System.out.println(values);
		
		System.out.println("=================================");
		Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
		
		for(Map.Entry<Integer, String> e : entrySet) {
			Integer key = e.getKey();
			String v = e.getValue();
			System.out.println(key + ":" + v);
		}
		
		
		System.out.println(map.containsKey(30));
		System.out.println(map.containsValue("wang"));
		
		
//		HashMap hm = (HashMap) map;
		
//		Hashtable ht = (Hashtable) map;
//		System.out.println(ht.elements());
		
	}

}
