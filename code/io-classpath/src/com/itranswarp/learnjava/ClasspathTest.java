package com.itranswarp.learnjava;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wxz 
 * 
 */
public class ClasspathTest {

	public static void main(String[] args) throws IOException {
//		很多Java程序启动的时候，都需要读取配置文件。例如，从一个.properties文件中读取配置：

		String conf = "C:\\Users\\86180\\Desktop\\default.properties";
		try (InputStream input = ClasspathTest.class.getResourceAsStream("/default.properties")) {
		    // TODO:
			 if (input != null) {
			        // TODO:
				 System.out.println((char)input.read());
			    }
			 else {
				 System.out.println("资源不存在");
			 }
		}
		
		try (InputStream input = new FileInputStream(conf)) {
		    // TODO:
			 System.out.println((char)input.read());
		}
		Properties props = new Properties();
//		把默认的配置放到jar包中，
		props.load(inputStreamFromClassPath("/default.properties"));
//		再从外部文件系统读取一个可选的配置文件，
		props.load(inputStreamFromFile("./conf.properties"));
//		做到既有默认的配置文件，又可以让用户自己修改配置：
	}

	private static InputStream inputStreamFromFile(String defaultPath) throws FileNotFoundException {
		// TODO Auto-generated method stub
		return new FileInputStream(defaultPath);
	} 

	private static InputStream inputStreamFromClassPath(String conf) {
		// TODO Auto-generated method stub
	
		return ClasspathTest.class.getResourceAsStream(conf);
	}

}
