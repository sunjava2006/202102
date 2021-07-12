package com.thzhima.advance.util;

import java.util.SortedSet;
import java.util.TreeSet;

public class Human implements Comparable<Human>{

	private String name;
	private int age;
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Human o) {
		
		return this.name.compareTo(o.name)<0 ? -1 : this.name.compareTo(o.name)>0? 1: this.age-o.age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void main(String[] args) {
		SortedSet<Human> set = new TreeSet<>();
		
		Human h = new Human("Wang", 33);
		Human h2 = new Human("Tang", 23);
		Human h4 = new Human("Tang", 53);
		Human h3 = new Human("Zhang", 25);
		
		set.add(h);
		set.add(h2);
		set.add(h3);
		set.add(h4);
		
		System.out.println(set);
	}

	
}
