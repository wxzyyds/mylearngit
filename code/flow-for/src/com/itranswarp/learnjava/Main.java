package com.itranswarp.learnjava;

/**
 * for练习
 */
public class Main {
//	给定一个数组，请用for循环倒序输出每一个元素：
	public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        for (int i=ns.length-1; 0<=i; i--) {
            System.out.println(ns[i]);
        }
//        利用for each循环对数组每个元素求和：
        int sum = 0;
        for (int i : ns) {
			sum += i;
		}
        System.out.println(sum); // 55
      /*
       * 圆周率π可以使用公式计算：
       */
        
        double pi = 0.0;
//        次数越多越精确
        int count = Integer.MAX_VALUE;
        double denominator = 1.0;
        for (double i = 1.0; i <= count; i++) { 	
        	pi +=denominator/(2*i-1); 
        	denominator = -denominator;
		}
        System.out.println("pi="+pi*4);
//        System.out.printf("pi=%5f",pi*4);
    }

}
