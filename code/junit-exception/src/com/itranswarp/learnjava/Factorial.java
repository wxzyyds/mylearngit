package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Factorial {

	public static long fact(long n) {
		if (n < 0) {
			throw new IllegalArgumentException();//非法参数异常
		}
		
		if (n > 20) {
			throw new ArithmeticException();//算数异常
		}
		
		long r = 1;
		for (long i = 1; i <= n; i++) {
			r = r * i;
		}
		return r;
	}

}
