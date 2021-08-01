package com.wangrui.base.type;

public class BaseType {

	public static void main(String[] args) {
		byte a = 127;// 8位一个字节，并且是有符号数 127~-128;
		short s = -32768;
		int i = 999999; // 编译器将整数看成int类型。
		long l = 9999999999999999L; // L 告诉编译器这个数是Long型。
		
		float f = 3.14f; // 编译器将小数看成double类型。
		double d = 3.14; 
		
		boolean b = true;
		
//		boolean bb = 1; Java语言中boolean类型的值中有true\false其它类型都不可以转换为 boolean类型。
		
		char c = 'a'; // 是存储单个字符的类型 32位
		char c2 = 97;
		System.out.println(c);
		System.out.println(c2);
		
		
		
		String str = "hello"; // String对象类型，不是基本数据类型
		
		//==============================================
		long l2 = i; // 32位->l2 63位 “小数据类型”赋值为“大数据类型”时，进行了“隐式”的数据类型转换。
		d = f;     // 编译器知道“小口袋”中的数据是可以放到“大口袋”中的。
		s = a;
		
		f = (float) d;   // “大口袋”中的数据放到“小口袋”中，编译器不知道能不能放的下。强制类型转换（编码的，是程序员保证的）。
		
		
		
	}
}
