package com.itranswarp.learnjava;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/*
 * 请利用Stack把字符串中缀表达式编译为后缀表达式，然后再利用栈执行后缀表达式获得计算结果
 */
public class SuffixExpressionMain {

	 public static void main(String[] args) {
	        String exp = "1 + 2 * (9 - 5)";
	        SuffixExpression2 se = compile(exp);
	        int result = se.execute();
	        System.out.println(result+"-->result");
	        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
	    }

	    static SuffixExpression2 compile(String exp) {
	        // TODO:将中缀表达式解构为后缀表达式,编译器编译过程
///初始化两个栈:运算符栈 s1 和储存中间结果的栈 s2
	    	Deque<String> s1 = new LinkedList<>();//运算符栈
	    	Deque<String> s2 = new LinkedList<>();//存储中间结果
//从左至右扫描中缀表达式,去空格

	    	String [] expStr = exp.replace(" ", "").split("");
	    	
	    	for (String str : expStr) {
	    		System.out.println(str);
//遇到操作数时，将其压 s2
	    		
			}
//
//遇到运算符时，比较其与 s1 栈顶运算符的优先级:
//
//如果 s1 为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈
//否则，若优先级比栈顶运算符的高，也将运算符压入 s1;
//否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到(4-1)与 s1 中新的栈顶运算符相比较;
//遇到括号时:
//
//如果是左括号“(”，则直接压入 s1
//如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
//重复步骤 2 至 5，直到表达式的最右边
//
//将 s1 中剩余的运算符依次弹出并压入 s2
//
//依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
//					
		


	        return new SuffixExpression2(s1,s2);
	    }
	    
	    public static boolean isNumber(String a) {
	    	Boolean flag = false;
	    	try {
				Integer.parseInt(a);//是整数
				flag = true;
			} catch (NumberFormatException e) {
				// TODO: 不是整数，判断小数
//				e.printStackTrace();
				try {
					Double.parseDouble(a);//是小数
					flag = true;
				} catch (NumberFormatException e2) {
					// TODO: 不是数字
//					e2.printStackTrace();
				
				}
			}
	    		    	
			return flag;
	    	
	    }
	   
	    
	    
	}

	class SuffixExpression2 {
		private Deque<String> stackNumber = new  LinkedList<String>();
		private Deque<String > stackSign = new  LinkedList<String>();
	    public SuffixExpression2(Deque<String> stackNumber, Deque<String> stackSign) {
			// TODO Auto-generated constructor stub
	    	this.stackNumber = stackNumber;
	    	this.stackSign = stackSign;
		}

		int execute() {
	        // TODO:计算后缀表达式
	    	int result = 0;
	    	String sign = this.stackSign.pop();
	    	String number = this.stackNumber.pop();
	    	
	    	if(stackNumber.size()!=0) {
	    		result = caculator(sign,number,this.stackNumber.pop());
	    		stackNumber.push(result+"");
	    		execute() ;	    		
	    	}
	        return result;
	    }
		
		private static int caculator(String sign,String x,String y) {
	    	int xy = 0;
	    	switch (sign) {
			case "+":
				xy = Integer.valueOf(x) + Integer.valueOf(y);
				break;
			case "-":
				xy = Integer.valueOf(x)  - Integer.valueOf(y);
				break;
			case "*":
				xy = Integer.valueOf(x)  * Integer.valueOf(y);
				break;
			case "/":
				xy = Integer.valueOf(x)  / Integer.valueOf(y);
				break;

			default:
				xy = -1;
				break;
			}
			return xy;
	    	
	    }
}