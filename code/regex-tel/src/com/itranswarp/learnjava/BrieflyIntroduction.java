package com.itranswarp.learnjava;

public class BrieflyIntroduction {
/**
 * 了解正则表达式
 * @param args
 */
	public static void main(String[] args) {
//判断字符串是否是有效电话号码
		isValidMobileNumber("11111111111");
//		isValidMobileNumber，编写正确的规则，通过正则表达式引擎去判断目标字符串是否符合
		isValidMobileNumberByRegex("21321551611616");
//		isValidEmail
//		isValidPhoneNumber
//		isValidZipCode
//		除了程序判断，更直接的方式时正则表达式判断
		
/*
 * 要判断用户输入的年份是否是20##年，我们先写出规则如下：
 * 一共有4个字符，分别是：2，0，0~9任意数字，0~9任意数字。
 * 对应的正则表达式就是：20\d\d，其中\d表示任意一个数字。
 * 把正则表达式转换为Java字符串就变成了20\\d\\d，注意Java字符串用\\表示\。
 * 最后，用正则表达式匹配一个字符串的代码如下：
 */
		if (is20Years("2023")) {
			System.out.println("年份正确");
		} else {
			System.err.println("年份错误");
		}

	}

private static boolean is20Years(String string) {
	// TODO Auto-generated method stub
//	设置正则规则
	String regex = "20\\d\\d";
	return string.matches(regex);//ctrl+左键可观察matches方法
	
}

private static void isValidMobileNumberByRegex(String s) {
	// TODO 判断是否是11位数字
	System.out.println(s.matches("\\d{11}"));

	System.out.println(s.matches("\\d{11}"));
}

private static void isValidMobileNumber(String s) {
	// 例如：010-1234567，123ABC456，13510001000等；
//	直观程序判断
	 // 是否是11位？
    if (s.length() != 11) {
//        return false;
    	System.out.println("不是11位");
    	return;
    }
    // 每一位都是0~9：
    
    for (int i = 0; i < s.length(); i++) {
    	char c = s.charAt(i);
    	 if (c < '0' || c > '9') {
    		 System.out.println("数字超出限制");
             return;
         }
	}
	
}

}
