package com.itranswarp.learnjava;

import java.util.StringJoiner;

public class StringJoinerTest {
//用指定分隔符拼接字符串数组时
	    public static void main(String[] args) {
	        String[] names = {"Bob", "Alice", "Grace"};
	        var sj = new StringJoiner(", ");
//	        需要给StringJoiner指定“开头”和“结尾”：
	        sj = new StringJoiner(", ","Hello","!");
	        for (String name : names) {
	            sj.add(name);
	        }
	        System.out.println(sj.toString());
	    }
//或者用String.join("",ArrayType);

}
