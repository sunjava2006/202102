package com.wangrui.javaadvance.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileUtil {

	public static void createFile(String fileName) throws IOException {
		File f = new File(fileName); // 创建文件
		createFile(f);

	}

	public static void createFile(File f) throws IOException {
		if (!f.exists()) { // 判断文件在磁盘上是否存在

			File dir = f.getParentFile(); // 取父目录。
			String dirName = dir.getAbsolutePath(); // 取文件绝对路径
			System.out.println(dirName);

			dir.mkdirs(); // 创建目录，可以创建多级目录。

			f.createNewFile(); // 在磁盘上创建文件
		}
	}

	public static void createFile(String dir, String fileName) throws IOException {
		File f = new File(dir, fileName);
		createFile(f);

	}
	
	public static boolean rm(String fileName) {
		File f = new File(fileName);
		return  rm(f);
	}
	
	public static boolean rm(File file) {
		return file.delete();//  删除文件
	}
	
	public static void rmdir(String dir) {
	    File d = new File(dir);	
	    rmdir(d);
	}
	
	public static void rmdir(File dir) {
		File[] children = dir.listFiles(); // 列出目录下的子文件（目录和方的都有）
		for(File f : children) {
			if(f.isFile()) {
				f.delete();
			}else {
				rmdir(f);
			}
		}
		dir.delete();
	}
	
	public static void aboutFile(String file) {
		File f = new File(file);
		
		System.out.println("execute:" + f.canExecute());
		f.setExecutable(false, false);
		System.out.println("execute:" + f.canExecute());
		
		System.out.println("read:" + f.canRead());
		System.out.println("write:" + f.canWrite());
		f.setWritable(false);
		System.out.println("write:" + f.canWrite());
		
		System.out.println("modify date: " + new Date(f.lastModified()));
		System.out.println("totalSpace:"+ f.getTotalSpace());
		System.out.println("freespace:" + f.getFreeSpace());
	}
}
