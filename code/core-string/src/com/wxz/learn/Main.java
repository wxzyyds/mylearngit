package com.wxz.learn;

import java.util.Arrays;

public class Main {
	/*
	 * String是一个引用类型，final修饰不可被继承，它本身也是一个class
	 */
	public static void main(System[] args) {
//		提供了"..."这种字符串字面量表示方法
		String st= null; //str引用为空，不占内存

		String str2= ""; //str引用一个空字符串
		String str1 = "hello";
//		"hello"是char[]表示的
		char [] ca = str1.toCharArray();
		ca = new char[]{'h','e','l','l','o'};
		System.out.println("直接打印会得到一串该数组变量地址"+ca);
		System.out.println("使用Arrays.toString(ca)打印会得到一串该数组变量的确切内容值"+Arrays.toString(ca));

		String str = new String(new char[] {'h','e','l','l','o'});//如下创建过程
/*
 * String 对象的不可变性
 8 String 类被 final 关键字修饰了，而且变量 char 数组也被 final 修饰了
 * */
		
/*
 * 以下是9之后就改了为了节省内存，因为大量的长度较短的String通常仅包含ASCII字符,使用者来说，String内部的优化不影响任何已有代码，因为它的public方法签名是不变的。
 * */
		/*	1.该创建对象方式通过String构造器
 *  public String(char value[]) {
        this(value, 0, value.length, null);
    }
    2.this调用令一个构造器
    调用了一系列方法，
    通过该
    byte[] val = StringUTF16.compress(value, off, len);
    最后强转为byte数组
    private final byte[] value;
	*/
//		String str3= new String("abc ");
//		str3.coder;
		/*	1.该创建对象方式通过String构造器
		 *  public String(String original) {
        this.value = original.value;
        this.coder = original.coder;
        this.hash = original.hash;
    }
		    2.在该构造器内部，依次初始化
		    private final byte[] value;
			*/
	}

}
