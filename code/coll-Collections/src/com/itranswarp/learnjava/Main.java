package com.itranswarp.learnjava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * collections
 * 
 * Collections类提供了一组工具方法来方便使用集合类：

	创建空集合；
	创建单元素集合；
	创建不可变集合；
	排序／洗牌等操作。
	是工具类
 */
public class Main {
	public static void main(String[] args) {
//创建空集合Collections
		Collections.emptyList();
		Collections.emptyMap();
		Collections.emptySet();
//		用各个集合接口提供的of(T...)* @since 9
		List.of();
//		创建单元素集合Collections/用各个集合接口提供的of(T...)* @since 9
		Collections.singleton(null);
		Collections.singletonList(null);
		Collections.singletonMap(null, null);
//		List.of(null);
//		排序Collections
//		Collections.sort(null);
		  List<String> list = new ArrayList<>();
	        list.add("apple");
	        list.add("pear");
	        list.add("orange");
	        // 排序前:
	        System.out.println(list);
	        Collections.sort(list);
	        // 排序后:
	        System.out.println(list);
//	        洗牌算法
	        Collections.shuffle(list);
//	        不可变集合  Collections传入可变集合x;无法添加或删除元素
//	        Collections.unmodifiableList(null);
//	        Collections.unmodifiableSet(null);
//	        Collections.unmodifiableMap(null);
	        /*
	         * 一个可变List封装成不可变List，
	         * 那么，返回不可变List后，
	         * 最好立刻扔掉可变List的引用，
	         * 这样可以保证后续操作不会意外改变原始对象，
	         * 从而造成“不可变”List变化了
	         */
//	        获得一个不可变List unmodifiableList
	        getMutable();
	        
//	        线程安全集合
	        Collections.synchronizedCollection(new ArrayList<>());
	        Collections.synchronizedList(new ArrayList<String>());
	        Collections.synchronizedMap(new HashMap<String, Integer>());
	        Collections.synchronizedSet(new HashSet<String>());	        	        
	}
	
	public static void getMutable() {
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        // 立刻扔掉mutable的引用:
        mutable = null;
        System.out.println(immutable);
    }

}
