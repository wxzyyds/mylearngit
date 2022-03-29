package com.itranswarp.learnjava;

/**
 * 编写了一个计算阶乘的类
 * 
 * @author liaoxuefeng
 */
public class Factorial {

	public static long fact(long n) {
		if (n < 0) {
			throw new IllegalArgumentException();
		}
		long r = 1;
		for (long i = 1; i <= n; i++) {
			r = r * i;
		}
		return r;
	}

}
