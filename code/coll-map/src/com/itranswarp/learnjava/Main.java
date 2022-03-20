package com.itranswarp.learnjava;

import java.util.*;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
	public static void main(String[] args) {
		List<Student> list = List.of(new Student("Bob", 78), new Student("Alice", 85), new Student("Brush", 66),
				new Student("Newton", 99));
		var holder = new Students(list);
		System.out.println(holder.getScore("Bob") == 78 ? "测试成功!" : "测试失败!");
		System.out.println(holder.getScore("Alice") == 85 ? "测试成功!" : "测试失败!");
		System.out.println(holder.getScore("Tom") == -1 ? "测试成功!" : "测试失败!");
	}
}
/*
 * 请编写一个根据name查找score的程序，并利用Map充当缓存，以提高查找效率：
 */
class Students {
	List<Student> list;
	Map<String, Integer> cache;

	Students(List<Student> list) {
		this.list = list;
		cache = new HashMap<>();
	
	}

	int getScore(String name) {
		// 先在Map中查找:
		Integer score = this.cache.get(name);
		if (score == null) {
			// Map中未找到在List中查找
			score = this.findInList(name);
			if(score ==null) {
				// List中未找到，返回-1	
				return -1;
			}else {
				// List中找到，存入map 二级缓存cache	
				cache.put(name, findInList(name));
			}
		
		}
		return score == null ? -1 : score.intValue();
	}

	Integer findInList(String name) {
		for (var ss : this.list) {
			if (ss.name.equals(name)) {
				return ss.score;
			}
		}
		return null;
	}
}

class Student {
	String name;
	int score;

	Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
