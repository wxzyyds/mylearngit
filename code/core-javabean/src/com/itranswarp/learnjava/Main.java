package com.itranswarp.learnjava;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws IntrospectionException {
//		枚举JavaBean属性	
		/*
		 * 若干private实例字段；
通过public方法来读写实例字段。
class被称为JavaBean：
*/
	        BeanInfo info = Introspector.getBeanInfo(Person.class);
	        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
	            System.out.println(pd.getName());
	            System.out.println("  " + pd.getReadMethod());
	            System.out.println("  " + pd.getWriteMethod());
	        }
	    
	}


}
