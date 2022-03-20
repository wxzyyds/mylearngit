package com.itranswarp.learnjava;

import java.util.Arrays;

/**
 * 降序排序
 */
public class Main {
	public static void main(String[] args) {
		int[] ns = { 28, 12, 89, 73, 65, 18,100, 96, 50, 8, 36 };
		// 排序前:
		System.out.println(Arrays.toString(ns));
		Arrays.sort(ns);
		for (int i = 0; i < (ns.length); i++) {				
					int temp = ns[ns.length-i-1];
					ns[ns.length-i-1] = ns[i];
					ns[i] = temp;		
			
					
				System.out.println(Arrays.toString(ns));	
			
		}
		// 排序后:
		System.out.println(Arrays.toString(ns));
		if (Arrays.toString(ns).equals("[100, 96, 89, 73, 65, 50, 36, 28, 18, 12, 8]")) {
			System.out.println("测试成功");
		} else {
			System.out.println("测试失败");
		}
	}
}
