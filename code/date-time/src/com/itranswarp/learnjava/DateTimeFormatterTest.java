package com.itranswarp.learnjava;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author wxz 旧的Date对象时，我们用SimpleDateFormat进行格式化显示
 *         新的LocalDateTime或ZonedLocalDateTime时，我们要进行格式化显示，就要使用DateTimeFormatter。
 * 
 * 
 *         DateTimeFormatter不但是不变对象，还是线程安全的
 * 
 * 
 */
public class DateTimeFormatterTest {
	public static void main(String[] args) throws IOException {
//		创建DateTimeFormatter时，通过传入格式化字符串实现：
		createDateTimeFormatter();

	}

	private static void createDateTimeFormatter() {
		// TODO 指定时间格式
		ZonedDateTime zdt = ZonedDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		System.out.println(formatter.format(zdt));
		
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("E, yyyy-MMMM-dd HH:mm", Locale.US);
		System.out.println(formatter2.format(zdt));
		
		var formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm ZZZZ");
		System.out.println(formatter3.format(zdt));

		var zhFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd EE HH:mm", Locale.CHINA);
		System.out.println(zhFormatter.format(zdt));
		
		var ldt = LocalDateTime.now();
		System.out.println(DateTimeFormatter.ISO_DATE.format(ldt));
		System.out.println(DateTimeFormatter.ISO_DATE_TIME.format(ldt));
		
		System.out.println(ldt.toLocalDate().toString());
		System.out.println(ldt.toLocalTime().toString());
	}

}
