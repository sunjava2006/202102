package com.wangrui.javaadvance.collection;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		
		SortedSet<Integer> set = new TreeSet<>();
		
		
		set.add(200);
		set.add(100);
		set.add(300);
		set.add(10);
		set.add(20); //
		set.add(400);
		set.add(20); //
		
		System.out.println(set.size());
		
		for(int i : set) {
			System.out.println(i);
		}
		
		SortedSet<String> set2 = new TreeSet<>();
		set2.add("china");
		set2.add("ok");
		set2.add("brand");
		set2.add("abc");
		
		System.out.println(set2);
		
		SortedSet<Human> set3 = new TreeSet<>();
		Human h1 = new Human("wang", 39);
		Human h2 = new Human("zhang", 34);
		Human h3 = new Human("li", 35);
		Human h4 = new Human("zao", 37);
		Human h5 = new Human("zao", 22);
		
		System.out.println(h4.equals(h5));
		
		set3.add(h1);
		set3.add(h2);
		set3.add(h3);
		set3.add(h4);
		set3.add(h5);
		
		System.out.println(set3);
		
	}
}
