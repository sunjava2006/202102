package com.thzhima.charsequence;

public class String2 {

	public static void main(String[] args) {
		String str = "i like Java.";
		
		char k = str.charAt(4); // 取出指定索引的字符
		System.out.println(k);
		
	    int code = str.codePointAt(8); // 取出指定索引字符的编码值。
	    System.out.println(code);
	    
	    int jat = str.indexOf('j', 8); // 从前先后从找指定的字符，返回所在位置的索引。找不到返回-1。
	    System.out.println(jat);
	    
	    System.out.println(str.lastIndexOf("jv"));
	    
	    System.out.println(str.concat(" i like python too.")); // 返回一个新的String对象，是两个字符串的拼接。
	    
	    System.out.println(str.substring(4, str.length()));
	    
	    System.out.println(str.toUpperCase());
	    
	    System.out.println(str);
	    
	    System.out.println(str.toLowerCase());
	    
	    System.out.println(str.contains("Java"));
	    System.out.println(str.startsWith("I like", 1));
	    System.out.println(str.endsWith("."));
	    
	    System.out.println("str.equals(\"I like Java.\") : " +(str.equals("I like Java.")));
	    
	    System.out.println("str.contentEquals(\"I like Java.\"): "+ (str.contentEquals("I like Java.")));
	    
	    System.out.println("忽略大小写的比较："+ (str.equalsIgnoreCase("i like JAVA.")));
	    
	    System.out.println(str.replaceAll("\\b", "*"));
	    System.out.println(str.replaceFirst("\\b", "*"));
	    System.out.println(str.replace("i", "I"));
	}
}
