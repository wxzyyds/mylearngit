package com.itranswarp.learnjava;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author wxz 
 * 从Java 7开始，提供了Files和Paths这两个工具类，能极大地方便我们读写文件。
 * 
 */
public class FilesTest {

	

	public static void main(String[] args) throws IOException {
//	我们要把一个文件的全部内容读取为一个byte[]，可以这么写：
		byte[] bs = Files.readAllBytes(Paths.get("src/file.txt"));
		System.out.println("bs"+bs);
//		是文本文件，可以把一个文件的全部内容读取为String：
		String string = Files.readString(Paths.get("src/file.txt"));
		System.out.println("string"+string);
// 可指定编码:
		String content2 = Files.readString(Paths.get("src/file.txt"), StandardCharsets.ISO_8859_1);
		System.out.println("content2"+content2);
		// 按行读取并返回每行内容:
		List<String> lines = Files.readAllLines(Paths.get("src/file.txt"));
		
		System.out.println(lines.toString());
		
//		写入文件也非常方便：
		// 写入二进制文件:
		byte[] data = bs;
		Files.write(Paths.get("file2.txt"), data);
		// 按行写入文本:
		Files.write(Paths.get("file2.txt"), lines);

		// 写入文本并指定编码:
		Files.writeString(Paths.get("file2.txt"), "文本内容...今天的天气不错", StandardCharsets.UTF_8);//如果指定编码和文件编码格式不同会报错
	}
	

	/*
	 * Files工具类还有copy()、delete()、exists()、move()等快捷方法操作文件和目录。
	 * Files提供的读写方法，
	 * 受内存限制，
	 * 只能读写小文件，
	 * 例如配置文件等，
	 * 不可一次读入几个G的大文件。
	 * 读写大型文件仍然要使用文件流，File
	 * 每次只读写一部分文件内容。
	 */

}
