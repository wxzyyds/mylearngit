package com.itranswarp.learnjava;
//设置一个链式操作的计数器，不断增加
public class Adder {
	 private int sum = 0;

	    public Adder add(int n) {
	        sum += n;
	        return this;
	    }

	    public Adder inc() {
	        sum ++;
	        return this;
	    }

	    public int value() {
	        return sum;
	    }
}
