package com.itranswarp.learnjava;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DymicLoadingClass {
/*
 * 动态加载class的特性对于Java程序非常重要。
 * 利用JVM动态加载class的特性，
 * 我们才能在运行期根据条件加载不同的实现类。
 * 例如，Commons Logging总是优先使用Log4j，
 * 只有当Log4j不存在时，
 * 才使用JDK的logging。
 * 利用JVM动态加载特性，
 * 大致的实现代码如下
 */
	
	// Commons Logging优先使用Log4j:
//	这就是为什么我们只需要把Log4j的jar包放到classpath中，Commons Logging就会自动使用Log4j的原因
	static Log factory = LogFactory.getLog(DymicLoadingClass.class);
	public static void main(String[] args) {
		boolean f = false;
		try {
				if (isClassPresent("org.apache.logging.log4j.Logger")) {
						f = true;
					
						factory = (Log) createLog4j();
				} else {
					f = false;
					factory =  createJdkLog();
				}
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		if(f) {
			factory.info("log4j");
		}
		else
		{
			factory.info("JDKLog");			
		}
		}
	}
	
	
	private static Log createJdkLog() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return  (Log) Class.forName("java.util.logging.Logger").getConstructor().newInstance();
	}
	
	private static LogFactory createLog4j() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		// TODO Auto-generated method stub
		 
		 return (LogFactory) Class.forName("com.sun.org.slf4j.internal").getConstructor().newInstance();
	}
	
	private static boolean isClassPresent(String name) {

		try {
			Class.forName(name);
			return true;
		} catch (Exception e) {
			return false;
		}
	

	}
}
