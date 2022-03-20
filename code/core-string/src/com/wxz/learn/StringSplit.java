package com.wxz.learn;

import java.util.Arrays;

public class StringSplit {
//分割字符串,返回数组字符串
	public static void main(String[] args) {
		String s = "A,B,C,D";
		String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}
		System.out.println(Arrays.toString(ss));
	}
}
