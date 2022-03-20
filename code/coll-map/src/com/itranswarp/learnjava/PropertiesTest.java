package com.itranswarp.learnjava;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 
 * @author wxz
 *properties是配置文件，以Key-Value格式存储的，且是String-String类型的
 *完全可以使用Map<String,String>来表示他
 *
 *在编写应用程序的时候，经常需要读写配置文件。
 *
 *例如，用户的设置：

	# 上次最后打开的文件:
	last_open_file=/data/hello.txt
	# 自动保存文件的时间间隔:
	auto_save_interval=60
	
	因为配置文件非常常用，所以Java集合库提供了一个Properties来表示一组“配置”。
	由于历史遗留原因，Properties内部本质上是一个Hashtable，
	但我们只需要用到Properties自身关于读写配置的接口。
 */
public class PropertiesTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileReader("F:\\conf\\setting.properties", StandardCharsets.UTF_8));//读取的时候指定UTF-8编码
		props.setProperty("url", "http://www.liaoxuefeng.com");
		props.setProperty("language", "Java");
//		store默认unicode编码
//		props.store(new FileOutputStream("F:\\conf\\setting.properties"), "这是写入的properties注释");
		props.store(new FileOutputStream("F:\\conf\\setting.properties"), "这是写入的properties注释");

		//	从内存读取一个字节流
		  String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01"+"\n" + "last_open_file=2019-08-09T14:3:06";
	        ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
	        Properties props2 = new Properties();
	        props2.load(input);

	        System.out.println("course: " + props2.getProperty("course"));
	        System.out.println("last_open_date: " + props2.getProperty("last_open_date"));
	        System.out.println("last_open_file: " + props2.getProperty("last_open_file"));
	        System.out.println("auto_save: " + props2.getProperty("auto_save", "60"));
	        
//	        可以从文件系统读取这个.properties文件：我们还可以提供一个默认值，这样，当key不存在的时候，就返回默认值

	        String f = "F:\\conf\\setting.properties";
	        Properties props3 = new Properties();
	        props.load(new java.io.FileInputStream(f));

	        String filepath = props3.getProperty("last_open_file");
	        String interval = props3.getProperty("auto_save_interval", "120");
	        System.out.println("filepath:"+filepath);
	        System.out.println("interval:"+interval);
	}
}

