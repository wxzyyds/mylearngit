package com.itranswarp.learnjava;

import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
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
