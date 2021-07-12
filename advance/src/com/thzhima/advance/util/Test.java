package com.thzhima.advance.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Test {
	  static final int MAXIMUM_CAPACITY = 1 << 30;
	 static final int tableSizeFor(int cap) {
	        int n = cap - 1;
	        n |= n >>> 1;
	        n |= n >>> 2;
	        n |= n >>> 4;
	        n |= n >>> 8;
	        n |= n >>> 16;
	        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	    }
	 
	public static void main(String[] args) throws InterruptedException {
//		System.out.println(tableSizeFor(33));
//		Map<String, Integer> map = new HashMap<>();
//		
//		System.out.println(map.put("Jack", 90));
//		System.out.println(map.put("Jack", 60));
//		
		
		Set<String> set = new MyHashSet<>();
		set.add("hi");
		set.add("hello");
		set.add("hi");
		System.out.println(set.size());
		
//		Iterator<String> ite = set.iterator();
//		while(ite.hasNext()) {
//			System.out.println(ite.next());
//			ite.remove();
//		}
		
		System.out.println(set.size());
		
		System.out.println(Arrays.toString(set.toArray(new String[set.size()])));
		
		System.out.println(set.contains("h44i"));
		
		List list = Arrays.asList("hi");
		System.out.println(set.containsAll(list));
		
		System.out.println(set.retainAll(list));
		System.out.println(set);
	}
}
