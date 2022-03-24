package com.itranswarp.learnjava;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author wxz 
 * 
 * 计算机存储的当前时间，本质上只是一个不断递增的整数。
 * Java提供的System.currentTimeMillis()返回的就是以毫秒表示的当前时间戳。
 * 
 * Instant.now()获取当前时间戳，效果和System.currentTimeMillis()
 */
public class InstantTest {
	public static void main(String[] args) throws IOException {
		Instant now = Instant.now();
        System.out.println(now.getEpochSecond()); // 秒
        System.out.println(now.toEpochMilli()); // 毫秒
        System.out.println(System.currentTimeMillis()); // 毫秒
        
        System.out.println(now.getNano()); // 纳秒
//        指定时间戳，创建附带时区的日期和时间
        createZonedDateTimeByInstantEpoh();
	}

	private static void createZonedDateTimeByInstantEpoh() {
		// TODO Auto-generated method stub
		Instant now = Instant.ofEpochMilli(1648140811543l);
		ZonedDateTime dateTime =   now.atZone(ZoneId.systemDefault());
		System.out.println(dateTime.format(DateTimeFormatter.ofPattern("yyyy MMM dd EE HH:mm",Locale.CHINA)));
	}

	

}
