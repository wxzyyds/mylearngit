package com.wxz.learn;

import java.util.Arrays;

public class StringQuote {
    public static void main(String[] args) {
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s = new Score(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
    }
}

class Score {
    private int[] scores;
    public Score(int[] scores) {
//    	复制数组的办法Arrays中的方法赋值
//    	Arrays.copyOf(scores, scores.length);
//    	直接克隆一个
//    	本质上是将传入的数组对象内容赋给新的数组
    	this.scores = new int[scores.length];
    	for (int i = 0; i < scores.length; i++) {
    		 this.scores[i]=scores[i];
		}
 
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}
