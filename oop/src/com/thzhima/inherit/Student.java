package com.thzhima.inherit;

public class Student extends Human{

//	public static String country = "�й�";
	
	public int studentID;
	
	public String name;
	
	public Student() {
		super();
		System.out.println("------Student()------");
	}
	
	public Student(String name, String gender, int studentID) {
		super(gender, name);
		this.studentID = studentID;
		
		this.name = name+"ͬ־";
	}
	
	public void study() {
		System.out.println(this.name + "ѧϰ��.");
	}
	
	@Override
	public void work() {
		System.out.println("����׼��������");
		super.work();
	}
	
	public void usualy() {
		this.work();
		super.work();
	}
	
//	@Override
//	public static void shootSun() {
//		System.out.println("����--------------->");
//	}
	
	public static void main(String[] args) {
		Human h = new Student("С��", "��", 20201023);
		h.work();
		
		Human h2 = new Human("mail","Jack");
		h2.work();
		
		Student s  = (Student) h;
		s.work();
		s.study();
		s.usualy();
		
		System.out.println(h.name);
		System.out.println(s.name);
		
		h.shootSun();
		Student.shootSun();
		
		System.out.println(Human.country);
		System.out.println(Student.country);
		
		
	}
	
	

}
