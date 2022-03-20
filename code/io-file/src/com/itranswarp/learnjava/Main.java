package com.itranswarp.learnjava;

import java.io.File;
import java.io.IOException;


/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {
	public static void main(String[] args) throws IOException {
		File currentDir = new File("C:\\\\Users\\\\86180\\\\Desktop\\\\图片\\\\doc");
		listDir(currentDir.getCanonicalFile(),new String());
	}

	static void listDir(File dir,String b) {
		// TODO: 递归打印所有文件和子文件夹的内容
		File[] fs = dir.listFiles();
		StringBuilder blank = new StringBuilder(" ").append(b);
        if (fs != null) {   
            for (File f : fs) {           	            	
            	System.out.println(blank+f.getName()+File.separator);
            	listDir(f,blank.toString());
            }
        }
    
	
	}
	

}
