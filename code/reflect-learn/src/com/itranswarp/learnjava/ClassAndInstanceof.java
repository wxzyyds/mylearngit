package com.itranswarp.learnjava;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClassAndInstanceof {
	static final Log log = LogFactory.getLog(ClassAndInstanceof.class);
/*
 * 用instanceof
 * 不但匹配
 * 指定类型，
 * 还匹配指定类型的子类。
 * 而用
 * ==判断class实例
 * 可以精确地判断
 * 数据类型，
 * 但不能作
 * 子类型比较。
 * 通常情况下，
 * 我们应该用instanceof判断数据类型，
 *    因为面向抽象编程的时候，
 *       我们不关心具体的子类型。
 *          只有在需要精确判断一个类型是不是某个class的时候，
 *             我们才使用==判断class实例。
 */
	
	public static void main(String[] args) {
		Integer n = new Integer(123);
		Class<?> class1 = n.getClass();
		boolean b1 = n instanceof Integer; // true，因为n是Integer类型
		boolean b2 = n instanceof Number; // true，因为n是Number类型的子类
		log.info(b1);
		log.info(b2);
		// true，因为n.getClass()返回Integer.class
		boolean b3 = class1 == Integer.class; 
		log.info(b3);
		// false，因为Integer.class!=Number.class 
		boolean b4 = class1 == Number.class; 
//		反射获取的是该实例对应CLASS的所有信息
		printObjectInfo(new Object());
	}
	
	@SuppressWarnings("deprecation")
	static void printObjectInfo(Object obj) {
	    Class<? extends Object> cls = obj.getClass();
	    log.info(cls);
		Object objc=null;
	    try {
			 objc = cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	    log.info(objc);
	}
}
