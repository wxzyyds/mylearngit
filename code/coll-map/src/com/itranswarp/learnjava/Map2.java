package com.itranswarp.learnjava;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author wxz
 *Map是一种映射表，可以通过key快速查找value。
 *由于list是顺序列表，所以在查找某个值的时候需要遍历，再筛选，或者需要知道该值对应的index，在返回。
 *
 *所以Map这种key：value一对一建立起来的键值映射，可以更快速的查找元素。
 */
public class Map2 {
	  public static void main(String[] args) {
	        Map<String, Integer> map = new HashMap<>();
	        map.put("apple", 123);
	        map.put("pear", 456);
	        map.put("banana", 789);
	        for (Map.Entry<String, Integer> entry : map.entrySet()) {
	            String key = entry.getKey();
	            Integer value = entry.getValue();
	            System.out.println(key + " = " + value);
	        }
	        
	        for (String entry : map.keySet()) {
	            String key = entry;
	            Integer value = map.get(key);
	            System.out.println(key + " = " + value);
	        }
	    }
}
