package com.itranswarp.learnjava;

import java.util.Scanner;

/**
 * 输入上次考试成绩（int）和本次考试成绩（int），
 * 然后输出成绩提高的百分比，
 * 保留两位小数位（例如，21.75%）
 */
public class Main {

	public static void main(String[] args) {
		int prev = 80;
		int score = 90;
		double percent = 0.1;
		var in = new Scanner(System.in);
		System.out.println("请输入上次成绩");
		 prev =  in.nextInt();
		System.out.println("请输入本次成绩");
		 score =  in.nextInt();
		
		 percent =(score-prev)*100/prev;
		System.out.printf("成绩提高了%.2f%%",percent);
	}

}
