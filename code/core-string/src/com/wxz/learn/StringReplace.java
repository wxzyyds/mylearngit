package com.wxz.learn;
//替换子串
public class StringReplace {
	public static void main(String[] args) {
//		在字符串中替换子串，有两种方法。一种是根据字符或字符串替换：
		
		String s = "hello";
		s = s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
		System.out.println(s);
		s = s.replace("ww", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
		System.out.println(s);
//		是通过正则表达式替换：

String s2 = "A,,B;C ,D";
s2 = s2.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
System.out.println(s2);
}
}
