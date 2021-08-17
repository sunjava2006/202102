package com.wangrui.javaadvance.collection;

public class Human extends Object{//implements //Comparable<Human>{

	public String name;
	public int age;
	
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
	public int hashCode() {
		return this.name.hashCode()+this.age;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}else {
			if(null != o) {
				Human h = (Human) o;
				if((h.name!=null? h.name.equals(this.name):null==this.name)
					&& (h.age==this.age)) {
					return true;
				}
				return false;
			}else {
				return false;
			}
		}
	}

//	@Override
//	public int compareTo(Human o) {
//		
//		return this.name.compareTo(o.name)!=0? this.name.compareTo(o.name):this.age-o.age;
//	}
	
	
}
