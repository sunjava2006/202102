package com.thzhima.oop;

public class Human {

	/*
	  *  ���ԣ����������ж���ı�����
	  * ��Ա�������������ԡ����������ж���ġ��Ǿ�̬�������� 
	 */
	String gender;
	String birthDate;
	String name;
	String address;
	int age;
	boolean isMarried; 
	
	{ //  �����
		System.out.println("=======================");
	}
	/**
	 * ���췽����û�з������ͣ���������������ͬ����newʱ�����á�
	 * ֻ�е��κ�һ�����춼������������£�ϵͳ�Ż�Ϊ���Ǵ����޲ε�Ĭ�Ϲ��졣
	 * ������죬ʲôҲ������
	 */
	Human(){   // 
		System.out.println("---------------------");
	}
	
	/* ��������ͬ�������б�ͬ���Ʒ������ء�����������ݲ�����ͬ��ȷ����ͬ�ķ�����
	 ����ͬ����ͬ�Σ��͹����˶�̬�����ڲ�ͬ�ķ������ݲ�ͬ�Ĳ����б���ȷ����
	 ��������������ڱ���ʱ����ȷ���ġ����ԳƱ���ʱ��̬����Java��������еĵ�һ�֡�
	 */
	Human(String gender, String name, String birthDate, String address,
		  int age, boolean  isMarried ){
		this.gender = gender;
		this.name = name;
		this.address = address;
		this.age = age;
		this.isMarried = isMarried;
		this.birthDate = birthDate;
	}
	
	/*
	 * ���������������ж���ĺ�����
	 * �����Ķ��壺
	 *    ����������������    ���������βΣ�{
	 *              ������...��
	 *      ....
	 * }
	 * void ��ʾ�÷���û�з���ֵ������������ͣ������������;��ǣ�int. 
	 */
	void work() { 
		System.out.println(name + "������...........");
	}
	
	int sum(int a, int b) {


		return a + b;
	}

	public static void main(String[] args) {
		
		// Human ���������� , li�Ƕ�������new �ؼ��֣�������������
		Human li = new Human();  
		System.out.println(li.name);
		System.out.println(li.address);
		System.out.println(li.gender);
		System.out.println(li.birthDate);
		System.out.println(li.age);
		System.out.println(li.isMarried);
		
		li.name = "������";
		li.address = "������������·8��";
		li.gender = "��";
		li.birthDate = "1979-12-30";
		li.age = 42;
		li.isMarried = true;
		
		System.out.println(li.name);
		System.out.println(li.address);
		System.out.println(li.gender);
		System.out.println(li.birthDate);
		System.out.println(li.age);
		System.out.println(li.isMarried);
		
		li.work();
		int result = li.sum(10, 20);
		System.out.println(result);
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		
		Human h = new Human("��", "��ˮ", "1990--4-4", "�Ͼ���������", 30, false);
		System.out.println(h.name);
		System.out.println(h.address);
		System.out.println(h.gender);
		System.out.println(h.birthDate);
		System.out.println(h.age);
		System.out.println(h.isMarried);
		
		
	}
	
	
	
	
}
