package com.wangrui.base.inherit;

public class Actor extends Human{

	public String alias;
	public String role;
	
	public Actor(String name, String gender, int age, String alias, String role) {
		super(name, gender, age);
		this.alias = alias;
		this.role = role;
	}
	
	public void sumba() {
		System.out.println("桑巴舞");
	}
	
	public void drive() {
		System.out.println("开车");
	}


	@Override
	public String toString() {
		return "Actor [alias=" + alias + ", role=" + role + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ "]";
	}

	public static void main(String[] args) {
		Human h = new Human("李二", "男", 44);
		System.out.println(h);
		h.sing();
		h.dance();
		
		Human h2 = new Actor("李三", "男", 45, "李大吹", "经理");
		System.out.println(h2);
		
		h2.sing();
		h2.dance();
		
		Actor a = (Actor) h2;
		a.drive();
		a.sumba();
	}
}
