package com.itranswarp.learnjava;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		String a = "12";
		String b = "x9";
		int c = 0;
		int d = 0;
		// TODO: 捕获异常并处理
		try {
			 c = stringToInt(a);
			 d = stringToInt(b);	
		}catch (NumberFormatException e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally {
			// TODO: handle finally clause
			System.out.println(c * d);
			System.out.println("end");
		}
		
	}

	static int stringToInt(String s) {
		return Integer.parseInt(s);
	}
}
