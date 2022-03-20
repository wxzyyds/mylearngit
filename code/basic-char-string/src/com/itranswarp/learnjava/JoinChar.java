package com.itranswarp.learnjava;

/**
 * char and String
 */
public class JoinChar {

	public static void main(String[] args) {
		int n1 = 'A'; // 字母“A”的Unicodde编码是65
		int n2 = '中'; // 汉字“中”的Unicode编码是20013
		// 请将下面一组int值视为字符的Unicode码，把它们拼成一个字符串：
		int a = 72;
		int b = 105;
		int c = 65281;
		String s = 'a' + 'b' + 'c'+"";
		System.out.println(s);
	}

}
