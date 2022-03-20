package com.itranswarp.learnjava;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author wxz
 *Map是一种映射表，可以通过key快速查找value。
 *HashMap是一种以空间换时间的映射表，
 *它的实现原理决定了内部的Key是无序的，
 *即遍历HashMap的Key时，
 *其顺序是不可预测的（但每个Key都会遍历一次且仅遍历一次）。
 *
 *但是SortedMap接口在内部对key进行了排序，而TreeMap是SortedMap的实现类
 *
 *使用TreeMap时，放入的Key必须实现Comparable接口
 *String Integer
 */
public class TreeMapTest {
	public static void main(String[] args) {  
		  Map<String, Integer> map = new TreeMap<>();
	        map.put("orange", 1);
	        map.put("apple", 2);
	        map.put("pear", 3);
	        for (String key : map.keySet()) {
	            System.out.println(key);
//	           这意味着，String在SortedMap是按字母排序的
	        }
	        
	        Map<Student2, Integer> map2 = new TreeMap<>(new Comparator<Student2>() {
	            public int compare(Student2 p1, Student2 p2) {
	            	 if (p1.score == p2.score) {
	            	        return 0;
	            	    }
	                return p1.score > p2.score ? -1 : 1;
	            }
	        });
	        map2.put(new Student2("Tom", 77), 1);
	        map2.put(new Student2("Bob", 66), 2);
	        map2.put(new Student2("Lily", 99), 3);
	        for (Student2 key : map2.keySet()) {
	            System.out.println(key);
	        }
	        System.out.println(map2.get(new Student2("Bob", 66))); // null?
      }
}

class Student2{
	public String name;
    public int score;
    Student2(String name, int score) {
        this.name = name;
        this.score = score;
    }
    public String toString() {
        return String.format("{%s: score=%d}", name, score);
    }
	
}
