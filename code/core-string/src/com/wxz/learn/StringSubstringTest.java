package com.wxz.learn;

public class StringSubstringTest {

	public StringSubstringTest() {
		// TODO Auto-generated constructor stub
	}
	//需要非空校验	
	public static void main(String[] args) {
		String str = "hello";
//		String父类之一CharSequence字符序列，String其实是一堆字符序列
		System.out.println(str.contains("ll"));
//		搜索子串,public int indexOf(String str) 返回下标，0start
		System.out.println(str.indexOf("e"));
//		搜索字符串的最后的某个字符串的index,不是字符串,或不存在返回-1
		System.out.println(str.lastIndexOf(1));//重载的另一个方法
		System.out.println(str.lastIndexOf(" "));
		System.out.println(str.lastIndexOf("e"));
//		搜索字符串的字符是否与输入参数匹配
		//需要非空校验
//		搜索字符串的第1个子串是与驶入参数匹配，匹配在返回true，不匹配返回false
		System.out.println(str.startsWith(""));
		System.out.println(str.startsWith("h"));
//		搜索字符串的第index个子串是与驶入参数匹配，匹配在返回true，不匹配返回false
		System.out.println(str.startsWith("h",1));
//		搜索字符串的最后一个字符，是否与输入的参数相同，相同返回true	不匹配返回false	
		System.out.println(str.endsWith(""));
		System.out.println(str.endsWith("o"));
//提取子串的例子：substring 单参数从0到地n个参数提取，多参数，从startindex开始到截取长度endindex-startindex结束
		str = "Hello".substring(2); // "llo"
		System.out.println(str);
		str = "Hello".substring(2, 4); //"ll"
		System.out.println(str);
	}
}
