package com.wangrui.javaadvance.io;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.OrderWith;

public class FileOperationTest {


	
//	@Test()
	public void testWriteFile() throws IOException {
		byte[] data = "hello Java. 你好中国。".getBytes();
		FileOperation.writeFile("d:/a.txt", data);
	}
	
//    @Test
	public void testReadFile() throws IOException {
		byte[] data = FileOperation.readFile("d:/a.txt");
		
		String s = new String(data);
		System.out.println(s);
	}
    
	@Test
    public void testCopy() throws IOException {
    	FileOperation.copy("D:\\录频\\22_File.mp4", "d:\\abc.mp4");
    }

}
