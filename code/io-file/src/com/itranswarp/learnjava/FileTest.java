package com.itranswarp.learnjava;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author wxz
 */
public class FileTest {

	public static void main(String[] args) throws IOException {
//		构造一个文件，传入一个文件路径
		File f = new File("C:\\Windows\\notepad.exe");
		System.out.println(f);
//		获取规范路径
		File fs = new File("..");// 获取上级目录
		System.out.println(fs.getPath());// 返回构造方法传入路径
		System.out.println(fs.getAbsolutePath());// 返回绝对路径
		System.out.println(fs.getCanonicalPath());// 返回规范路径
//      File对象有一个静态变量用于表示当前平台的系统分隔符：
		System.out.println(File.separator); // 根据当前平台打印"\"或"/"
//          文件和目录
		File f1 = new File("C:\\Windows");
		File f2 = new File("C:\\Windows\\notepad.exe");
		File f3 = new File("C:\\Windows\\nothing");
		System.out.println(f1.isFile());// 判断该File对象是否是一个已存在的文件
		System.out.println(f1.isDirectory());// 判断该File对象是否是一个已经存在的目录
		System.out.println(f1.canRead());// 判断该File对象是否可读
		System.out.println(f1.canWrite());// 判断该File对象是否可写
		System.out.println(f1.canExecute());// 判断该File对象是否执行
		System.out.println(f1.length());// 判断该File对象的文件字节大小
		System.out.println(f2.isFile());
		System.out.println(f2.isDirectory());
		System.out.println(f2.canRead());// 判断该File对象是否可读
		System.out.println(f2.canWrite());// 判断该File对象是否可写
		System.out.println(f2.canExecute());// 判断该File对象是否执行
		System.out.println(f2.length());// 判断该File对象的文件字节大小
		System.out.println(f3.isFile());
		System.out.println(f3.isDirectory());
		System.out.println(f3.canRead());// 判断该File对象是否可读
		System.out.println(f3.canWrite());// 判断该File对象是否可写
		System.out.println(f3.canExecute());// 判断该File对象是否执行
		System.out.println(f3.length());// 判断该File对象的文件字节大小
//创建和删除文件
		File file = new File("F:\\a.txt");
		if (file.isFile() || file.isDirectory()) {

			System.out.println("该文件/或目录存在");
			if (file.delete()) {
				// 删除文件成功:
				System.out.println("删除文件成功");
			}

		} else {

			if (file.createNewFile()) {

				System.out.println("文件创造成功");

			}

		}
//	创建临时文件
	     File fTemp = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
	     fTemp.deleteOnExit(); // JVM退出时自动删除
	        System.out.println(fTemp.isFile());
	        System.out.println(fTemp.getAbsolutePath());
//	        遍历文件和目录
//	        list()和listFiles()列出目录下的文件和子目录名
	        File fd = new File("C:\\Windows");
	        File[] fs1 = fd.listFiles(); // 列出所有文件和子目录
	        printFiles(fs1);
	        File[] fs2 = fd.listFiles(new FilenameFilter() { // 仅列出.exe文件
	            public boolean accept(File dir, String name) {
	                return name.endsWith(".exe"); // 返回true表示接受该文件
	            }
	        });
	        
	        printFiles(fs2);
//	        创建和删除目录
//	        File对象如果表示一个目录，可以通过以下方法创建和删除目录：
	        
	        if (f3.isDirectory()) {
	        	f3.mkdir();//：创建当前File对象表示的目录；
	        	
	        	f3.mkdirs();//：创建当前File对象表示的目录，并在必要时将不存在的父目录也创建出来；
	        	f3.delete();//：删除当前File对象表示的目录，当前目录必须为空才能删除成功。
	        }
	}
	static void printFiles(File[] files) {
        System.out.println("==========");
        if (files != null) {
            for (File f : files) {
                System.out.println(f);
            }
        }
        System.out.println("==========");
    }

}
