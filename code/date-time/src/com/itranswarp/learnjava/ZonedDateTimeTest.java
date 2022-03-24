package com.itranswarp.learnjava;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


/**
 * @author wxz 表示一个带时区的日期和时间，我们就需要ZonedDateTime.
 * 
 *         LocalDateTime加ZoneId。ZoneId是java.time引入的新的时区类
 * 
 * 
 */
public class ZonedDateTimeTest {
	public static void main(String[] args) throws IOException {
//		创建一个ZonedDateTime对象，
//		createZonedDateTime();
//	时区转换
//		ZonedDateTime，将其转换为本地时间就非常简单
		ZonedExchange();
	}

	private static void ZonedExchange() {
		// TODO ZonedDateTime对象,通过withZoneSameInstant()将关联时区转换到另一个时区，
		// 转换后日期和时间都会相应调整。
		ZonedDateTime dateTime = ZonedDateTime.now();
		ZonedDateTime dateTime2 = dateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
		
		System.out.println(dateTime);
		System.out.println(dateTime2);
		System.out.println(dateTime2.toLocalDateTime());//直接丢失时区信息
		

	}

	private static void createZonedDateTime() {
		// TODO 创建一个带时区的对象
		ZonedDateTime dateTime = ZonedDateTime.now();// 默认时区
		System.out.println("ZonedDateTime创建一个默认时区的对象" + "：\n" + dateTime);
		ZonedDateTime dateTime2 = ZonedDateTime.now(ZoneId.of("America/New_York"));// 用指定时区获取当前时间
		System.out.println("ZonedDateTime创建一个用指定时区获取当前时间的对象" + "：\n" + dateTime2);
		LocalDateTime ldt = LocalDateTime.of(2019, 9, 15, 15, 16, 17);
		ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault());
		ZonedDateTime zny = ldt.atZone(ZoneId.of("America/New_York"));
		System.out.println("LocalDateTime创建一个默认时区的对象" + "：\n" + zbj);
		System.out.println("LocalDateTime创建一个指定时区获取当前时间的对象" + "：\n" + zny);
	}

}
