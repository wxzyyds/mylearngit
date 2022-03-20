package com.itranswarp.learnjava;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 从文件中读取所有字节，并转换成char然后拼成一个字符串
 * 
 * 提取一个readAsString()的方法
 * 
 * 构造一个InputStream对String readAsString(InputStream input)方法进行测试
 * 
 * 
 *  */
public class Main {
	public static void main(String[] args) throws IOException {
    byte[] data = { 72, 101, 108, 108, 111, 33 };
    try (InputStream input = new ByteArrayInputStream(data)) {
//    	test readAsString
        String s = readAsString(input);
        System.out.println(s);
    }
}

	private static String readAsString(InputStream input)  throws IOException {
		// TODO read inpustream and append  String.
		int n = 0;
		StringBuffer sb = new  StringBuffer();
		try(input){
			
			while((n =input.read())!=-1) {
				sb.append((char)n);
			}
		}
		return sb.toString();
	}

	
	

}
