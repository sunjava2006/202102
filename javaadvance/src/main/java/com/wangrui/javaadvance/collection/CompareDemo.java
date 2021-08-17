package com.wangrui.javaadvance.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class CompareDemo {

	public static void main(String[] args) {
		Comparator<Human> comparator = (a, b)->{return a.age-b.age==0?(a.name.compareTo(b.name)):a.age-b.age;};
			
		SortedSet<Human> set = new TreeSet<>(comparator);
		
		Human h1 = new Human("wang", 39);
		Human h2 = new Human("zhang", 34);
		Human h3 = new Human("li", 22);
		Human h4 = new Human("zao", 37);
		Human h5 = new Human("zao", 22);
		
		System.out.println(h4.equals(h5));
		
		set.add(h1);
		set.add(h2);
		set.add(h3);
		set.add(h4);
		set.add(h5);
		
		System.out.println(set);
		
		
		
	}
}
