package com.itranswarp.learnjava;

import java.util.Arrays;
import java.util.Objects;

import org.apache.commons.logging.LogFactory;

import org.apache.commons.logging.Log;


/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
	static final Log log = LogFactory.getLog(Main.class);
/*
 * 反射就是Reflection，Java的反射是指
 * 程序在运行期可以
 * 拿到一个对象的所有信息。
 */
	public static void main(String[] args) throws Exception{
//		正常情况下，如果我们要调用一个对象的方法，或者访问一个对象的字段，通常会传入对象实例：
//		反射是为了解决在运行期，对某个实例一无所知的情况下，如何调用其方法。
		Person p = Person.class.newInstance();
		// TODO: 利用反射给name和age字段赋值:

		System.out.println(p.getName()); // "Xiao Ming"
		System.out.println(p.getAge()); // 20
		Class<?> cls=null;
		try {
//			同样的如果获取了一个类的class实例信息,我们就可以通过该实例反射获取该类的所有信息,类名,字段,方法,构造方法,包名,父类,父类接口
//	直接通过一个class的静态变量class来获取
			cls = String.class;
//			如果有一个实例变量,可以通过.getClass()方法来获取该对象的class实例
			p.getClass();
//			知道一个class的完整类名，可以通过静态方法Class.forName()获取
			cls = Class.forName("java.lang.Class");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (Objects.nonNull(cls)) {
//		由于class实例在jvm中唯一,所以class对象可用==比较		
				log.info(cls.getName());
				log.info(Arrays.toString(cls.getAnnotatedInterfaces()));
				log.info(cls.arrayType());
				log.info(cls.getCanonicalName());
				log.info(cls.getClass());
//				log.info(cls.getConstructor());
				log.info(Arrays.toString(cls.getMethods()));
				log.info(Arrays.toString(cls.getFields()));
				log.info(Arrays.toString(cls.getInterfaces()));
				log.info(cls.getSuperclass());
				log.info(cls.getTypeName());
				log.info(cls.getPackage());
				
			}
			else {
				log.error("获取不到该对象实例");
			}
		}
	}
}
