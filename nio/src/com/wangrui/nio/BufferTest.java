package com.wangrui.nio;

import java.nio.IntBuffer;

public class BufferTest {

	public static void main(String[] args) {
		IntBuffer buffer = IntBuffer.allocate(10);
		
		System.out.println("capacity: " + buffer.capacity());
		System.out.println("limit: " + buffer.limit());
		System.out.println("positiion: " + buffer.position());
		
		
	}
}
