package com.itranswarp.learnjava;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 
 * @author wxz
 * 
 *         Date和Calendar System.out.println(Integer.toString(n,16));
 *
 *         println方法会将不同类型的数据转化为字符串打印在控制台
 *
 *         直接以字符串的形式存储，那么不同的格式，不同的语言会让表示方式非常繁琐。
 *
 *         先要理解数据的存储和展示。
 *         整数的存储格式非常简单，而我们将他通过不同的格式转换NumberFormat，去转换为需要的格式的字符串然后去打印
 *
 *         因此计算机中，某个时间，时刻的存储为一个整数。
 */
public class DatetTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
//		十六进制的形式打印整数，或者，如果n表示一个价格，我们就以$123,400.00的形式来打印它：
		int n = 123400;
//整数转16进制   Integer.toString(n,16) Integer.toHexString(n)
//字符串转16进制	Integer.valueOf(String n, 16)
//		System.out.println(Integer.toHexString(n));
//		System.out.println(Integer.toString(n, 16));
//		// $123,400.00 整数转美金 NumberFormat.getCurrencyInstance(Locale.US).format(n)
//		System.out.println(NumberFormat.getCurrencyInstance(Locale.CHINA).format(n));
//		System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
//		System.out.println(NumberFormat.getCurrencyInstance(Locale.FRANCE).format(n));
//		System.out.println(NumberFormat.getCurrencyInstance(Locale.GERMAN).format(n));
//		System.out.println(NumberFormat.getCurrencyInstance(Locale.ITALIAN).format(n));
//		System.out.println(NumberFormat.getCurrencyInstance(Locale.KOREA).format(n));
//整数123400是数据的存储格式
//    打印的各种各样的字符串，则是数据的展示格式。
//    展示格式本质就是一个转换方法
		/*
		 * 日期和时间： 2019-11-20 0:15:01 GMT+00:00 2019年11月20日8:15:01 11/19/2019 19:15:01
		 * America/New_York 则以上时间日期展示格式，某个时刻在不同时区的对应日期和时间的展示
		 * “同一个时刻”在计算机中存储的本质上只是一个整数，我们称它为Epoch Time。 Epoch
		 * Time是计算从1970年1月1日零点（格林威治时区／GMT+00:00）到现在所经历的秒数 Epoch Time又称为时间戳
		 */
//    要获取当前时间戳，可以使用System.currentTimeMillis()
//		System.out.println(System.currentTimeMillis());
//
////    标准库API
////    java.util这个包里面，主要包括Date、Calendar和TimeZone
//
//		getDate(); // 获取当前时间:Date获取并设置年、月、日、时、分、秒
//		getDateAndFormat();// SimpleDateFormat将Date转为预定格式
//
////      Calendar  和Date比，主要多了一个可以做简单的日期和时间运算的功能。
//		getCalendar();// 获取年月日时分秒
//		getCustomizationCalendar();// 简单格式化一个自定义Calendar，并转Date

//     TimeZone于   Calendar和Date相比，它提供了时区转换的功能。时区用TimeZone对象表示：
//		getTimeZone();
		getTimeZoneChange();
//    Java 8引入的，定义在java.time这个包里面，主要包括LocalDateTime、ZonedDateTime、ZoneId等
	}

	public static void getDate() {
		Date date = new Date();
		System.out.println(date.getYear() + 1900); // 必须加上1900
		System.out.println(date.getMonth() + 1); // 0~11，必须加上1
		System.out.println(date.getDate()); // 1~31，不能加1
		// 转换为String:
		System.out.println(date.toString());
		// 转换为GMT时区:
		System.out.println(date.toGMTString());
		// 转换为本地时区:
		System.out.println(date.toLocaleString());
	}

	public static void getDateAndFormat() {
		var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 自定义格式的输出
		var sdf2 = new SimpleDateFormat("E MMM dd, yyyy");// 格式化预定义了许多不同的格式
		System.out.println("sdf++++++++" + sdf.format(new Date()));
		System.out.println("sdf2++++++++" + sdf2.format(new Date()));

	}

//	calender比Date多了一些简单运算
	public static void getCalendar() {
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		int m = 1 + calendar.get(Calendar.MONTH);
		int d = calendar.get(Calendar.DAY_OF_MONTH);
		int w = calendar.get(Calendar.DAY_OF_WEEK);
		int hh = calendar.get(Calendar.HOUR_OF_DAY);
		int mm = calendar.get(Calendar.MINUTE);
		int ss = calendar.get(Calendar.SECOND);
		int ms = calendar.get(Calendar.MILLISECOND);
		System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);
	}

//calendar设置特定时间日期
	public static void getCustomizationCalendar() {
		// 当前时间:
		Calendar c = Calendar.getInstance();
		// 清除所有:
		c.clear();
		// 设置2019年:
		c.set(Calendar.YEAR, 2019);
		// 设置9月:注意8表示9月:
		c.set(Calendar.MONTH, 8);
		// 设置2日:
		c.set(Calendar.DATE, 2);
		// 设置时间:
		c.set(Calendar.HOUR_OF_DAY, 21);
		c.set(Calendar.MINUTE, 22);
		c.set(Calendar.SECOND, 23);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(c.getTime()));
		// 2019-09-02 21:22:23
	}

//	获得时区，TimeZone
	public static void getTimeZone() {
		TimeZone tzDefault = TimeZone.getDefault(); // 当前时区
		TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00"); // GMT+9:00时区
		TimeZone tzNY = TimeZone.getTimeZone("America/New_York"); // 纽约时区
		System.out.println(tzDefault.getID()); // Asia/Shanghai
		System.out.println(tzGMT9.getID()); // GMT+09:00
		System.out.println(tzNY.getID()); // America/New_York
	}
	
//	TimeZone change
	public static void getTimeZoneChange() {
		Calendar calendar =  Calendar.getInstance();
//		清除calendar
//		calendar.clear();
//		设置为北京时区
		calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
// 		设置年月日时分秒:
//		calendar.set(2019, 10 /* 11月 */, 20, 8, 15, 0);
// 		显示时间:
		var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		System.out.println(sdf.format(calendar.getTime()));
	}

}
