package com.itranswarp.learnjava;

import java.util.Scanner;

/**
 * switch实现石头/剪子/布并判断胜负
 */
public class Main {

	public static void main(String[] args) {
		var in=new Scanner(System.in);
		while(true) {
			System.out.println("please choice:");
			System.out.println(" 1: Rock");
			System.out.println(" 2: Scissors");
			System.out.println(" 3: Paper");
			// 用户输入:
			int choice = in.nextInt();
			// 计算机随机数 1, 2, 3:
			int random = 1 + (int) Math.random() * 3;
			
			System.out.println("You select "+select(choice));
			
			System.out.println("PC select "+select(random));
			
			if(choice==random) {
				System.out.println("Draw");
			}else if(choice<random) {
				System.out.println("PC Lose");
			}else if(choice>random) {
				System.out.println("You Win");
			}
			System.out.println("game go on？");
			System.out.println(" 1: Yes");
			System.out.println(" 2: No");
			choice = in.nextInt();
			if(choice==2) {
				System.out.println("Game exit");
				break;
			}else {
				System.out.println("Game go on");
			}
		}
		
		
		in.close();
	}
	
	public static String select(int n) {
		String a="";
		switch (n) {
		case 1: {
			a = "Rock";
			break;
		}
		
		case 2: {
			a = "Scissors";
			break;
		}
		
		case 3: {
			a = "Paper";
			break;
		}
		
		default:
			a = "No Select";
			break;
		}
	
		return a;
		
	}

}


