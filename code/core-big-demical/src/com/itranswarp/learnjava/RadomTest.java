package com.itranswarp.learnjava;

import java.util.Random;

public class RadomTest {
	public static void main(String[] args) {
//		创建Random实例时，如果不给定种子，使用系统时间作为种子，因此每次运行时间不同，伪随机数序列不同
		Random r = new Random();
		r.nextInt(); // 2071575453,每次都不一样
		System.out.println(r.nextInt());
		r.nextInt(10); // 5,生成一个[0,10)之间的int
		System.out.println(r.nextInt(10));
		r.nextLong(); // 8811649292570369305,每次都不一样
		System.out.println(r.nextLong());
		r.nextFloat(); // 0.54335...生成一个[0,1)之间的float
		System.out.println(r.nextFloat());
		r.nextDouble(); // 0.3716...生成一个[0,1)之间的double
		System.out.println(r.nextDouble());
		
//	当制指定一个随机数种子，每次随机数序列都是重复，为伪随机数列	
		 Random r2 = new Random(12345);
	        for (int i = 0; i < 10; i++) {
	            System.out.println(r2.nextInt(100));
	        }
	        // 51, 80, 41, 28, 55...
	}
}
