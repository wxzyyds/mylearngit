package com.itranswarp.learnjava;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CatchException {
//捕获异常
	
	/*
	 * try...catch语句，
	 * 把可能发生异常的代码放到try {...}中，
	 * 然后使用catch捕获对应的Exception及其子类：
	 */
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		  byte[] bs = toGBK("中文");
		  try {
			byte[] bs2 = toGBK2("中文2");
			System.out.println(Arrays.toString(bs2));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		  System.out.println(Arrays.toString(bs));
	}
	static byte[] toGBK(String s) {
        try {
            // 用指定编码转换String为byte[]:
            return s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            // 如果系统不支持GBK编码，会捕获到UnsupportedEncodingException:
        	// 先记下来再说:
            e.printStackTrace();

            System.out.println(e); // 打印异常信息
            return s.getBytes(); // 尝试使用用默认编码
        }
    }

//	如果不抛出异常,或者捕获异常并处理,文件无法编译通过
	static byte[] toGBK2(String s) throws UnsupportedEncodingException {
        return s.getBytes("GBK");
    }
}
