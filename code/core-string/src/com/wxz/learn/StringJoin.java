package com.wxz.learn;

public class StringJoin {
public static void main(String[] args) {
//	拼接字符串,参数指定分隔符，再给定一个数组
	String[] arr = {"A", "B", "C"};
	String s = String.join("***", arr); // "A***B***C"
	System.err.println( s);
}
}
