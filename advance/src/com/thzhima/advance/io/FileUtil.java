package com.thzhima.advance.io;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class FileUtil {

	public static File createFile(String fileName) throws IOException {
		File  f = null;
		f = new File(fileName); // 创建一个文件对象，物理不一定存在
		f.createNewFile();
		return f;
	}
	
	public static File createFile(String path, String fileName) throws IOException {
		File  f = null;
		f = new File(path, fileName); // 创建一个文件对象，物理不一定存在
		f.createNewFile();
		return f;
	}
	
	public static File createDir(String dirName) throws IOException {
		File  d = null;
		d = new File(dirName); // 创建一个文件对象，物理不一定存在
		d.mkdirs(); // 可创建多级目录。mkdir（）只能创建一级目录。
		return d;
	}
	
	public static File createDir(String path, String dirName) throws IOException {
		File  d = null;
		d = new File(path, dirName); // 创建一个文件对象，物理不一定存在
		d.mkdirs(); // 可创建多级目录。mkdir（）只能创建一级目录。
		return d;
	}
	
	public static boolean remove(String file) {
		File f = new File(file);
		return f.delete();
	}
	
	public static void removeDir(File dir) {
		File[] children = dir.listFiles(); // 列出子文件
		if(null != children) {
			for(File f: children) {
				if(f.isFile()) {  // 判断文件对象是不是文件类型
					f.delete();
				}
				else {
					removeDir(f);
				}
			}
		}
		
		dir.delete();
	}
	
	public static void removeDir(String dir) {

		File d = new File(dir);
		String[] children = d.list();
		
		if(null != children) {
			
			System.out.println(children.length);
			
			for(int i=0; i<children.length; i++) {
			
				String child = d.getAbsolutePath()+"\\"+ children[i];
				
				File f = new File(child);

				if(f.isFile()) { // 判断文件对象在物理上是不是文件（就不是目录）
					f.delete();
				}else{
					removeDir(child);
				}
				
			}
		}
		
		
		d.delete();
	}
	
	public static long size(File file) {
		return file.length(); // 文件大小
	}
	
	public static boolean[] rwx(File f) {
		boolean[] b = new boolean[3];
		b[0] = f.canRead();
		b[1] = f.canWrite();
		b[2] = f.canExecute();
		return b;
	}
	
	public static void setRWX(File f, boolean[] rwx) {
		f.setReadable(rwx[0]);
		f.setWritable(rwx[1]);
		f.setExecutable(rwx[2]);
	}
	
	public static Date lastModifyTime(File f) {
		return new Date(f.lastModified()); // 获取文件最后修改时间 
	}
	
	public static void updateLastModifyTime(File f, Date date) {
		// 修改文件最后修改时间 
		f.setLastModified(date.getTime());
	}
	
	public static String getName(File f) {
		return f.getName();
	}
	
	public static String getAbsoluteName(File f) {
		return f.getAbsolutePath();
	}
	
	public static String getParentName(File f) {
		return f.getParent();
	}
	
	public static void main(String[] args) {
		try {
//			FileUtil.createFile("d:/","b.txt");
//			FileUtil.createDir("d://a/b/c", "aa/bb");
//			System.out.println(FileUtil.remove("d:/a/b/c/aa/bb/123.txt"));
//			FileUtil.removeDir(new File("d:/a/b/c/aa"));
			File f = new File("d:/a/b/c/a.txt");
//			System.out.println(FileUtil.size(f));
//			
//			FileUtil.setRWX(f, new boolean[]{true, false, false});
//			
//			System.out.println(Arrays.toString(FileUtil.rwx(f)));
//		
//			Calendar c = Calendar.getInstance();
//			c.set(Calendar.MONDAY, 12);
//			Date d = c.getTime();
//			FileUtil.updateLastModifyTime(f, d);
//			System.out.println(FileUtil.lastModifyTime(f));
			
			System.out.println(getName(f));
			System.out.println(getAbsoluteName(f));
			System.out.println(getParentName(f));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
