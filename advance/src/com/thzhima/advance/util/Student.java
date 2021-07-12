package com.thzhima.advance.util;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Student {

	String name;
	int age;
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}



	public static void main(String[] args) {
		
		Comparator<Student> comparator = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name)<0 ? -1 : o1.name.compareTo(o2.name)>0? 1: o1.age-o2.age;
			}
			
			
		};
		
		TreeSet<Student> set = new TreeSet<>(comparator);
		
		Student s = new Student("Jack", 11);
		Student s2 = new Student("Mary", 11);
		Student s3 = new Student("Will", 31);
		Student s4 = new Student("Rose", 22);
		set.add(s);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		System.out.println(set);
		
	}
}
