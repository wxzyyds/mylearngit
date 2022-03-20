package com.itranswarp.learnjava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * @author wxz 
 * 一个Java对象要能序列化，必须实现一个特殊的java.io.Serializable接口
 */
public class SerializeTest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 为了避免这种class定义变动导致的不兼容，
	 * Java的序列化允许class定义一个特殊的serialVersionUID静态变量，
	 * 用于标识Java类的序列化“版本”，通常可以由IDE自动生成。
	 * 如果增加或修改了字段，可以改变serialVersionUID的值，
	 * 这样就能自动阻止不匹配的class版本：
	 */

	public static void main(String[] args) throws IOException {
//		序列化是指把一个java对象转为Byte数组，使用到ObjectOutputStream，把一个java对象写入字节流
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)){
//			写入int
			objectOutputStream.writeInt(123456);
//			写入string
			objectOutputStream.writeUTF("hello world");
//			写入object
			objectOutputStream.writeObject(1285.55441);
		}
		 System.out.println(Arrays.toString(byteArrayOutputStream.toByteArray()));
//		 反序列化是从一个字节流读取java对象
//		 byteArrayOutputStream.toByteArray()
		 ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
		 try (ObjectInputStream input = new ObjectInputStream(arrayInputStream)) {
			    int n = input.readInt();
			    String s = input.readUTF();
			    Double d = (Double) input.readObject();
			    System.out.println(n + "----"+s+"-----"+d);
			    /*
			     * readObject()可能抛出的异常有：
			     * ClassNotFoundException：没有找到对应的Class；
			     * InvalidClassException：Class不匹配。
			     */
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}

	

}
