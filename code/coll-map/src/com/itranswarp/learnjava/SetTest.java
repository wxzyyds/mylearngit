package com.itranswarp.learnjava;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author wxz
 * 首先Map是存储与key-value的键值对映射，通过key的hashcode去直接获取value的索引
 * 且充当key的对象不能重复，
 * 且key的对象要复写equals方法
 * 必须复写hashcode方法。
 * 
 * 那么set就可以用于存储key
 * 因为set用于存储不重复的元素集合
 */
public class SetTest {
	public static void main(String[] args)  {
//		Set实际上相当于只存储key、不存储value的Map。我们经常用Set用于去除重复元素
//		Set<String> set = new HashSet<>();
		Set<String> set = new TreeSet<>();//HashSet遍历是无序的，TreeSet遍历是有序的
//		添加的元素必须正确实现Comparable接口，如果没有实现Comparable接口，那么创建TreeSet时必须传入一个Comparator对象。
		set.add("xxx");
		set.add("xxl");
		set.add("xxd");
		 for (String s : set) {
	            System.out.println(s);
	        }
	}
}

