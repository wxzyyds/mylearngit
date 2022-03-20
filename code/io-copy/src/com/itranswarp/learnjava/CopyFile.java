package com.itranswarp.learnjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class CopyFile {

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.err.println("Usage:\n  java CopyFile.java <source> <target>");
			System.exit(1);
		}
		copy(args[0], args[1]);
	}

	static void copy(String source, String target) throws IOException {
		// 友情提示：测试时请使用无关紧要的文件
		// TODO:
		try(FileInputStream inputStream = new FileInputStream(source);FileOutputStream fileOutputStream = new FileOutputStream(target)){
			long copyStr = inputStream.transferTo(fileOutputStream);
			System.out.println(copyStr);
		}
	}
}
