package com.itranswarp.learnjava;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class xxxx {
	static String change(String exp) {
		// TODO: 1 2 9 5 - * +
		//判断是否为数字 正则
		Pattern pattern = Pattern.compile("[0-9xy]");
		//判断是否为运算符 正则
		Pattern pattern1 = Pattern.compile("[-+*/]");
		//返回结果
		StringBuilder result = new StringBuilder();

		//储存中间结果的栈（结果栈）
		Stack<String> s1 = new Stack<>();
		//运算符栈
		Stack<String> s2 = new Stack<>();

		//字符串变char[]
		char[] chars = exp.toCharArray();

		for (char aChar : chars) {

		String s = String.valueOf(aChar);
		Matcher matcher = pattern.matcher(s);
		Matcher matcher1 = pattern1.matcher(s);

		//遇到操作数时，将其压s1(运算符栈)
		if (matcher.matches()) {
		s1.push(s);
		}

		//遇到运算符
		if (matcher1.matches()) {

		while (true) {
		//如果s2（运算符栈）为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
		if (s2.size() == 0 || s2.peek().equals("(")) {
		s2.push(s);
		break;
		}
		//否则，若优先级比栈顶运算符的高，也将运算符压入s2（运算符栈）；
		if ((s.equals("*") || s.equals("/")) && (s2.peek().equals("+") || s2.peek().equals("-"))) {
		s2.push(s);
		break;
		//否则，将s2栈顶的运算符弹出并压入到s1中，再次转到与s2中新的栈顶运算符相比较；
		} else {
		s1.push(s2.pop());
		}
		}
		}

		//遇到括号时
		//如果是左括号"("，则直接压入s2（运算符栈）
		if (s.equals("(")) {
		s2.push(s);
		}
		//如果是右括号")"，则依次弹出s2栈顶的运算符，并压入s1，直到遇到左括号为止，此时将这一对括号丢弃
		if (s.equals(")")) {
		for (int i = 0; i < s2.size(); i++) {
		String pop = s2.pop();
		if (!pop.equals("(")) {
		s1.push(pop);
		}
		}
		}
		}

		int size = s2.size();
		for (int i = 0; i < size; i++) {
		String pop = s2.pop();
		s1.push(pop);
		}

		for (String s : s1) {
		result.append(s);
		}

		return result.toString();
		}
}
