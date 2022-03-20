package com.itranswarp.learnjava;

import java.math.BigInteger;

public class Main {

	public static void main(String[] args){
//		BigInteger用于表示任意大小的整数，extends Number不可变类
		/*
		 * 转换为byte：byteValue()
			转换为short：shortValue()
			转换为int：intValue()
			转换为long：longValue()
			转换为float：floatValue()
			转换为double：doubleValue()
		 */
		
		BigInteger big = new BigInteger("1234567890");
//		幂运算 pow
		System.out.println(big.pow(5));
		/*
		 * 如果我们使用的整数范围超过了long型怎么办？
		 * 这个时候，就只能用软件来模拟一个大整数。
		 * java.math.BigInteger就是用来表示任意大小的整数。
		 * BigInteger内部用一个int[]数组来模拟一个非常大的整数：
		 */
//	BigInteger的运算	只能由，该工具提供的运算方法进行
		BigInteger i1 = new BigInteger("1234567890");
		BigInteger i2 = new BigInteger("12345678901234567890");
		BigInteger sum = i1.add(i2);
		System.out.println(sum);
//		和long型整数运算比，BigInteger不会有范围限制，但缺点是速度比较慢
		BigInteger i = new BigInteger("123456789000");
		System.out.println(i.longValue()); // 123456789000
//		使用longValueExact()方法时，精确的转为long，如果超出了long型的范围，会抛出ArithmeticException
		System.out.println(i.multiply(i).longValueExact()); // java.lang.ArithmeticException: BigInteger out of long range
//		BigInteger的值甚至超过了float的最大范围（3.4x1038）,会输出无穷大
		 BigInteger n = new BigInteger("999999").pow(99);
	        float f = n.floatValue();
	        System.out.println(f);
	}


}
