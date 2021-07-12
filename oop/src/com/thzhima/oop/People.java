package com.thzhima.oop;

public class People {

	String name = "xxx";
	int age;
	boolean married;
	
	{
		age = 2;
		System.out.println("-----------------");
	}
	
	People(){
		age = 1;
	}
	
	People(String name){
		this(name, 1, false); // �Ե�ǰ�๹�������
	}
	
	People(String name, int age, boolean married){
		this.name = name;
		this.age= age;
		this.married = married;
	}
	
	void a() {
		
	}
	
	void b() {
		this.a();
	}
	
	void work() {
		System.out.println(this.name + "������");
	}
	
	void work(String task) {
		System.out.println(this.name + "���"+task+"��");
	}
	
//	String work(String target) { // �����б���ͬ�����벻ͨ����
//		System.out.println(this.name + "���"+target+"��");
//		return "";
//	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		/* 1��new �������󣬰��ඨ�壬�����ڴ�ռ䣬��ȱʡ��ʼ�����ԡ�
		 * 2��������е����ݣ����ڶ��󴴽�֮��ִ�С�
		 * 3��ִ�й���
		 * 
		 * new һ��������������£�
		 *    һ�Ǵ�������ȱʡ��ʼ������
		 *    ���ǳ�ʼ������ �������������Ը���Ĭ��ֵ���ڴ���顢�ڹ����г�ʼ����������ԡ�
		 */
		People p = new People("wang", 20, false);
		
		p.work();
		p.work("ѧϰJava");
		
		String name = p.name;
		int age = p.age;
		
		System.out.println(name);
		System.out.println(age);
		
		p.married = true;
		System.out.println(p.married);
	}
	
}
