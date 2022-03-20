package com.itranswarp.learnjava;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author wxz
 */
public class PathTest2 {

	public static void main(String[] args) throws IOException {

        Path p1 = Paths.get(".", "project", "study"); // 构造一个Path对象
        System.out.println("构造一个Path对象----"+p1);
        Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
        System.out.println("转换为绝对路径----"+p2);
        Path p3 = p2.normalize(); // 转换为规范路径
        System.out.println("转换为规范路径----"+p3);
        File f = p3.toFile(); // 转换为File对象
        System.out.println("转换为File对象----"+f);
        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }    
	}
	

}
