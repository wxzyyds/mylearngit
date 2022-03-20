package com.itranswarp.learnjava;

public class BinaryConversion {

	public String getBinary(String s,int i) {
//		先将字符串转为integer
		Integer is = Integer.parseInt(s);
//		再返回对应字符串的转换进制 2~36，默认十进制
		return Integer.toString(is, i);
		
	}
}
