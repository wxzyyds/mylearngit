package com.wxz.learn;

public class StringCompare {

	public StringCompare() {
		// 字符串比较
//		实际上是想比较字符串的内容是否相同。必须使用equals()方法而不能用==，忽略大小写比较，使用equalsIgnoreCase()方法
//		==比较的是引用地址
//		Java编译器在编译期，会自动把所有相同的字符串当作一个对象放入常量池，自然s1和s2的引用就是相同的。
//如果使用构造器创建一些新的空串，则引用改变		
	}
	public static void main(String[] args) {
		String a = "";
		String a2 = "";
		
		String a3 = new String("");
		System.out.println(a.equals(a3));
		System.out.println(a==a3);
		System.out.println(a.compareTo(a2));
//		若果相同 返回 int 0，否则返回 int -1
	}
}
