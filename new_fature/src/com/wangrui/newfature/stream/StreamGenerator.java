package com.wangrui.newfature.stream;

import java.util.stream.Stream;

public class StreamGenerator {

	public static void main(String[] args) {
		Stream<Integer> s = Stream.iterate(2, (i)->i*2);
		
		s.limit(4).forEach(System.out::println); //?
		
		
		Stream.generate(Math::random) //?
		.limit(4)
		.forEach((i)->System.out.println(i));
	}
}
