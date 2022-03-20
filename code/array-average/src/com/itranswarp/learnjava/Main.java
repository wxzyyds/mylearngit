package com.itranswarp.learnjava;

/**
 * 二维数组
 */
public class Main {
	public static void main(String[] args) {
		// 用二维数组表示的学生成绩:
		int[][] scores = { //
				{ 82, 90, 91 }, //
				{ 68, 72, 64 }, //
				{ 95, 91, 89 }, //
				{ 67, 52, 60 }, //
				{ 79, 81, 85 }, //
		};
		// 求每个学生平均成绩:求每一科平均成绩
		double average = 0;
		int counts = 0;
		for (int[] is : scores) {
			for (int i : is) {
				average+=i;
				
			}
			counts+=is.length;
		}
		System.out.println(average/counts);
		average = average/counts;
		
		if (Math.abs(average - 77.733333) < 0.000001) {
			System.out.println("测试成功");
		} else {
			System.out.println("测试失败");
		}
	}
}
