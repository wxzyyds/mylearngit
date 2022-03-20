package com.wxz.learn;

public class StringFormat {

//	格式化字符串
//	字符串提供了formatted()方法和format()静态方法，可以传入其他参数，替换占位符，然后生成新的字符串：
	public static void main(String[] args) {
		/*
		 *  %s：显示字符串；
			%d：显示整数；
			%x：显示十六进制整数；
			%f：显示浮点数。
		 */
	String s = "Hi %s, your score is %d!";
	System.out.println(s.formatted("Alice", 80));		
	System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));		
	}
}
