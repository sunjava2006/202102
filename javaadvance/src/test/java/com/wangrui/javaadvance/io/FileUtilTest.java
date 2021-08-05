package com.wangrui.javaadvance.io;

import java.io.IOException;

import junit.framework.TestCase;

public class FileUtilTest extends TestCase {

//	public void testCreateFile() throws IOException {
//		FileUtil.createFile("d:/a/b/c/abc.txt");
//		FileUtil.createFile("d:/aa/bb/cc", "abc.txt");
//	}
	
//	public void testRm() {
//		FileUtil.rm("d://a/b/c/abc.txt");
//		boolean ok = FileUtil.rm("d:/a/b/c");
//		assertEquals(ok, true);
//	
//	}
	
//	public void testRmDir() {
//		FileUtil.rmdir("d:/aa");
//	}

	
	public void testaboutFile() {
		FileUtil.aboutFile("d:/abc.txt");
	}
}
