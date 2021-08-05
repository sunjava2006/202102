package com.wangrui.javaadvance.io;

import java.io.File;
import java.io.IOException;

public class TempFile {

	public static void main(String[] args) throws IOException, InterruptedException {
//		File tem = File.createTempFile("abc", ".log");
		
		File tem = new File("d:/tmp.tmp");
		tem.createNewFile();
		
		System.out.println(tem.getAbsolutePath());
		
		Thread.sleep(10000);
		
		tem.deleteOnExit();
	}
}
