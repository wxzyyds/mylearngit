package com.wxz.learn;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringUnicode {
/*
 *字符编码 （各国语言不同，则对应的编码格式不同）
 * 为了给字符编码(AbCD  123 常用符号)，ANSI制定了一套ASCII编码占用一个字节，编码范围从0到127，最高位始终为0的编码规范，计算采用
 * 
 * 把汉字也纳入计算机编码，一个字节是不够的。GB2312标准使用两个字节表示一个汉字，其中第一个字节的最高位始终为1，以便和ASCII编码区分开。例如，汉字'中'的GB2312编码是0xd6d0。计算机采用
 * 
 * 日文有Shift_JIS编码，韩文有EUC-KR编码，这些编码因为标准不统一，同时使用，就会产生冲突。
 * 
 * 统一全球所有语言的编码，全球统一码联盟发布了Unicode编码，把世界上主要语言都纳入同一个编码，这样，中文、日文、韩文和其他语言就不会冲突。
 * 
 * 编码标准不同，字符对应的编码不同。
 * 
 * UTF-8编码， 是一种变长编码，用来把固定长度的Unicode编码变成1～4字节的变长编码。通过UTF-8编码，英文字符'A'的UTF-8编码变为0x41，正好和ASCII码一致，而中文'中'的UTF-8编码为3字节0xe4b8ad。
 * 是容错能力强
 * 经常用来作为传输编码
 * 
 * 转换编码后，就不再是char类型，而是byte类型表示的数组。
 */
	public static void main(String[] args) throws UnsupportedEncodingException {
//	字符串转换成其他编码,	getBytes方法指定编码转换格式得到byte数组
		byte[] b1 = "Hello".getBytes(); // 按系统默认编码转换，不推荐
		byte[] b2 = "Hello".getBytes("UTF-8"); // 按UTF-8编码转换
		byte[] b3 = "Hello".getBytes("GBK"); // 按GBK编码转换
		byte[] b4 = "Hello".getBytes(StandardCharsets.UTF_8); // 按UTF-8编码转换
		
		System.out.println(Arrays.toString(b1));
		System.out.println(Arrays.toString(b2));
		System.out.println(Arrays.toString(b3));
		System.out.println(Arrays.toString(b4));
// 把已知格式编码转换为String，可以这么做new String（byte[] bits，编码格式）
		String s1 = new String(b1, "GBK"); // 按GBK转换
		String s2 = new String(b2, StandardCharsets.UTF_8); // 按UTF-8转换
		System.out.println(s1);
		System.out.println(s2);
//String和char[]类型可以互相转换不能直接转换
		char[] cs = "Hello".toCharArray(); // String -> char[]
		String s = new String(cs); // char[] -> String
	
	System.out.println(" String -> char[]  "+Arrays.toString(cs));
	System.out.println(" char[] -> String  "+s.toString());
//	默认加上toString
	System.out.println(" char[] -> String  "+s);
//	如果修改了char[]数组，String并不会改变：
	cs[0] = 'a'; 
	System.out.println(" char[] -> String  "+s);
//	通过new String(char[])创建新的String实例时，
//	它并不会直接引用传入的char[]数组，
//	而是会复制一份，
//	所以，修改外部的char[]数组不会影响String实例内部的char[]数组，
//	因为这是两个不同的数组。
//	从String的不变性设计可以看出，如果传入的对象有可能改变，我们需要复制而不是直接引用。
	
	
	
	}
}
