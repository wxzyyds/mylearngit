package com.itranswarp.learnjava;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author wxz ZipInputStream是一种FilterInputStream，它可以直接读取zip包的内容： InputStream
 *         FilterInputStream InflaterInputStream ZipInputStream JarInputStream
 */
public class ZipTest {

	public static void main(String[] args) throws IOException {
		/*
		 * JarInputStream是从ZipInputStream派生， 它增加的主要功能是直接读取jar文件里面的MANIFEST.MF文件。
		 * `因为本质上jar包就是zip包，只是额外附加了一些固定的描述文件
		 */
//		读取zip包
//		传入一个FileInputStream作为数据源
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\86180\\Desktop\\图片\\doc\\src.zip");
		readZip(fileInputStream);
//	写入zip包

		writeZip(null);

	}

	public static File[] readZip(FileInputStream fileInputStream) {
		try (ZipInputStream inputStream = new ZipInputStream(fileInputStream)) {
			ZipEntry en = null;
			while ((en = inputStream.getNextEntry()) != null) {
				String name = en.getName();
				System.out.println(name);
				if (!en.isDirectory()) {
					int n;
					while ((n = inputStream.read()) != -1) {
						System.out.print((char) n);
					}
				}
				
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void writeZip(FileOutputStream fileOutputStream) {
		/*
		 * ZipOutputStream是一种FilterOutputStream，
		 * 可以直接写入内容到zip包。
		 * 要先创建一个ZipOutputStream，
		 * 通常是包装一个FileOutputStream，
		 * 每写入一个文件前，先调用putNextEntry()，
		 * 用write()写入byte[]数据，
		 * 写入完毕后调用closeEntry()结束这个文件的打包。
		 */
		try (ZipOutputStream outputStream = new ZipOutputStream(fileOutputStream)) {
			File[] files = new File[1000];
			for (File file : files) {
				outputStream.putNextEntry(new ZipEntry(file.getName()));
				outputStream.write(getFileDataAsBytes(file));
				outputStream.closeEntry();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static byte[] getFileDataAsBytes(File File) throws IOException {

		byte[] bytes;

		try(InputStream input=new FileInputStream(File);

		ByteArrayOutputStream output = new ByteArrayOutputStream()) {

		int n;

		while((n=input.read())!=-1) {

		output.write(n);

		};

		bytes=output.toByteArray();

		};

		//System.out.println(bytes.length);

		return bytes;

		}
}
