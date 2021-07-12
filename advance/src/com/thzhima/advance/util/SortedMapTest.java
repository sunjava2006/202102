package com.thzhima.advance.util;

import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapTest {

	public static void main(String[] args) {
		
		SortedMap<Integer, String> map = new TreeMap<>();
		
		map.put(3, "广州");
		map.put(6, "南京");
		map.put(5, "武汉");
		map.put(1, "北京");
		map.put(2, "上海");
		
		System.out.println(map.keySet());
		
		Iterator<Integer> ite = map.keySet().iterator();
		while(ite.hasNext()) {
			Integer key = ite.next();
			System.out.println(key + ":" + map.get(key));
		}
		
		System.out.println(map.values());
		
		SortedMap<Integer, Object> map2 = new TreeMap<>();
		map2.put(2, new Object());
	}

}
