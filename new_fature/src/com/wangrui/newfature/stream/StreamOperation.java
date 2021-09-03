package com.wangrui.newfature.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperation {

	public static void main(String[] args) {
		People p1 = new People("Wang", 22);
		People p2 = new People("Zhang", 21);
		People p3 = new People("Tang", 24);
		People p4 = new People("Huang", 25);
		People p7 = new People("Huang", 25);
		People p5 = new People("Lu", 17);
		People p6 = new People("Jing", 12);
		
		Collection<People> collection = Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
		
		Stream<People> stream = collection.stream();
		
		// 筛选 age>21
		stream = stream.filter((p)->{System.out.println("__");return p.getAge()>12;});
		
		// 取指定数量
//		stream  = stream.limit(4);
		
		// skip
//		stream = stream.skip(1);
		
		// 去重equals相等的元素
		stream = stream.distinct();
		
		//=======================映射============================
		
		Stream<String> s= stream.map((t)->t.getAge()>18?"old":"yong");
		
		s.forEach(System.out::println);
		
		
		
		// flatmap
		List<Integer> li1 = Arrays.asList(10,20,3);
		List<Integer> li2 = Arrays.asList(40,5,6);
		Stream<List<Integer>> s2 = Stream.of(li1, li2);
		Stream<Integer> s3 = s2.flatMap((i)->i.stream());
		//=====================排序==================
		s3 = s3.sorted((a, b)->b-a);
		
		// 查找匹配
//		boolean gt10 = s3.noneMatch((i)->i>10);//s3.allMatch((i)->i>2);
//		System.out.println(gt10);
		
		//s3.forEach(System.out::println);
//		Optional<Integer> op = s3.findAny(); //s3.findFirst();
//		System.out.println(op.get());
		
//		long count = s3.count();
//		System.out.println(count);
		
//		System.out.println(s3.min(Integer::compare).get());
		
		List<Integer> li = s3.collect(Collectors.toList());
		System.out.println(li);
		
		//====================归约=======================
		li = Arrays.asList(1,2,3);
		Integer i = li.stream().reduce(0, (a, b)->a*b);
		System.out.println(i);
		
		
		
		
	}
}
