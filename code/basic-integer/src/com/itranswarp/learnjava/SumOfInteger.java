package com.itranswarp.learnjava;

/**
 * Sum of integers.
 */
public class SumOfInteger {

	public static void main(String[] args) {
		int n = 100;
		// TODO: sum = 1 + 2 + ... + n
		int sum = sum2(n);
		System.out.println(sum);
	}
	
	public static int sum(int n) {
		int b = 0 ;
		for (int i = 0; i <=n; i++) {
			b+=i;
		}
		return b;
		
	}
	
	public static int sum2(int n) {
		
		return (1+n)*n/2;
		
	}

}
