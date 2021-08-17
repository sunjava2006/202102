package com.wangrui.javaadvance.collection;

import java.util.HashSet;
import java.util.Set;

public class Equ {
	
	public static void main(String[] args) {
		
		Set<Human> set = new HashSet<>();
		
		Human h = new Human("Li", 22);
		Human h2 = new Human("Zhang", 21);
		Human h3 = new Human("Huang", 26);
		Human h4 = new Human("Zao", 22);
		Human h5 = new Human("Zao", 22);
		
		set.add(h);
		set.add(h2);
		set.add(h3);
		set.add(h4);
		set.add(h5);
		
		System.out.println(set.size());
		
		
	}

}
