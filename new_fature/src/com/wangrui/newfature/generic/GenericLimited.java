package com.wangrui.newfature.generic;

import java.util.ArrayList;
import java.util.List;

import com.wangrui.newfature.lambda.Human;

public class GenericLimited{

	public void todo(List<? extends Human> list) {
		Human h = list.get(0);
		h.sleep();
	}
	
	public <T> T to() {
		return (T)(new Integer(3).toString());
	}
	
	public static void main(String[] args) {
		GenericLimited gl = new GenericLimited();
		
		 String s = gl.to();
		
		System.out.println(s);
		
		List<Student> list = new ArrayList<>();
		list.add(new Student());
		gl.todo(list);
		
		List<String> lists = new ArrayList<>();
		lists.add("hi");
		
//		gl.todo(lists);
		
		
		List<Human> li = new ArrayList<>();
		li.add(new Student());
		li.add(new Human());
		
		
		List<? extends Object> olist = null;
		List<String> slist = null;
		
		olist = slist; // 泛型之间没有继承关系
		
		
		List<? super Integer> ilist = null;
	    List<Number> nlist = new ArrayList<>();
	    
	    ilist = nlist;
	    
	    
	    List<? extends Object> oli = null;
	    oli = nlist;
	    oli = slist;
	    
	    
	    Ext ext = new Ext() {
			@Override
			public  String ext() {
				return "hi";
			}
		};
		
		String ss = ext.ext();
		System.out.println(ss);
	    
	}

	

	
}
