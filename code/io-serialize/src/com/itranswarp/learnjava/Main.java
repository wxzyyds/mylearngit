package com.itranswarp.learnjava;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 1.io流：inputStream，outputStream byte[]字节流,read write char[]字符流/通过对应流的转换器对象，可以将字节流转为字符流
 * 2.FIle：文件和文件夹都是该对象，通过相应方法API获取，文件，文件夹。进行，读（判断是否存在）写（创建），文件流
 * 3.序列化是将java对象转为二进制字节，byte数组。反序列化是将java对象从byte数组中读取出来。不安全，更好序列化使用json等格式用数据结构来实现
 * 4. Filter或者装饰器模式：对I/O相关类inputStream，outputStream的子类设计，
 *  FileInputStream,ServletInputStream,Socket.getInputStream()等基础组件+
 *  FilterInputStream 下的BufferedInputStream，DigestInputStream，CipherInputStream等功能组件
 *  这种基础组件+Filter下的功能组件模式称之为装饰器模式，或者filter模式
 * 5.filer模式下的相关功能包，ZipInputStream,ZipOutputStream可以直接读写zip文件。
 * 6.		Properties props = new Properties();
 * 		把默认的配置放到jar包中，
 * 		props.load(inputStreamFromClassPath("/default.properties"));
 * //		再从外部文件系统读取一个可选的配置文件，
 * 		props.load(inputStreamFromFile("./conf.properties"));
 * //		做到既有默认的配置文件，又可以让用户自己修改配置：
 * 
 * 7.系统打印，由将字节流打印输出的，PrintStream对象；有将字符流打印输出的PrintWriter对象
 * 8.从Java 7开始，提供了Files和Paths这两个工具类，能极大地方便我们读写小文件。大文件还得FIle文件流
 *  */
public class Main {
	public static void main(String[] args) throws IOException {
    byte[] data =  "hello, world!".getBytes("UTF-8");
    try (CountInputStream input = new CountInputStream(new ByteArrayInputStream(data))) {//try(;;)获取流
    	   int n;
           while ((n = input.read()) != -1) {//read依次读取
               System.out.println((char)n);
           }
           System.out.println("Total read " + input.getBytesRead() + " bytes");
    }
}

}

class CountInputStream extends FilterInputStream {
    private int count = 0;

    CountInputStream(InputStream in) {
        super(in);
    }

    public int getBytesRead() {
        return this.count;
    }

    public int read() throws IOException {
        int n = in.read();
        if (n != -1) {
            this.count ++;
        }
        return n;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int n = in.read(b, off, len);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }
}
