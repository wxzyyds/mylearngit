package com.wxz.learn;

import 		java.util.logging.Logger;

public class StringTrimTest {
	public static void main(String[] args) {
		"  \tHello\r\n ".trim(); // "Hello"
		String str = "  \tHello\r\n ";
//		去除首位的空白字符，包括空格，\t,\r,\n;不改变原有字符串内容，返回新的字符串
		str.trim();
		System.out.println(str);
		str=str.trim();
		System.out.println(str);
//		strip()方法也可以移除字符串首尾空白字符。它和trim()不同的是，类似中文的空格字符\u3000也会被移除：
		str="\u3000Hello\u3000".strip(); // "Hello"
		Logger.getLogger(str);
		str=" Hello ".stripLeading(); // "Hello "
		Logger.getLogger("").info(str);;
		str=" Hello ".stripTrailing(); // " Hello"
		Logger.getLogger("").info(str);;
//	isEmpty()和isBlank()来判断字符串是否为空和空白字符串
		; 
		System.out.println("".isEmpty());
		System.out.println("  ".isEmpty());
		System.out.println("  \n".isBlank());
		System.out.println(" Hello ".isBlank());}
}
