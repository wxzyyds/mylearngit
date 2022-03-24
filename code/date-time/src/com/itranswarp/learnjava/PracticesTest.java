package com.itranswarp.learnjava;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author wxz
 * 
 *         历史遗留问题 旧版本日期时间Api，非遗留代码不使用
 */
public class PracticesTest {
	public static void main(String[] args) throws IOException {
//		旧API转新API
		// Date -> Instant:
		Instant ins1 = new Date().toInstant();
		// Calendar -> Instant -> ZonedDateTime:
		Calendar calendar = Calendar.getInstance();
		Instant ins2 = calendar.toInstant();
		ZonedDateTime zdt = ins2.atZone(calendar.getTimeZone().toZoneId());
//新API转旧API  借助long型时间戳做一个“中转”
		// ZonedDateTime -> long:
		ZonedDateTime zdt1 = ZonedDateTime.now();
		long ts = zdt1.toEpochSecond() * 1000;

		// long -> Date:
		Date date = new Date(ts);

		// long -> Calendar:
		Calendar calendar1 = Calendar.getInstance();
		calendar1.clear();
		calendar1.setTimeZone(TimeZone.getTimeZone(zdt.getZone().getId()));
//		新的ZoneId转换为旧的TimeZone，需要借助ZoneId.getId()返回的String完成
		calendar1.setTimeInMillis(zdt.toEpochSecond() * 1000);

//		在数据库中存储日期和时间
//		java.sql.Date，它继承自java.util.Date
		/*
		 * 在数据库中，也存在几种日期和时间类型： DATETIME：表示日期和时间； DATE：仅表示日期； TIME：仅表示时间；
		 * TIMESTAMP：和DATETIME类似，但是数据库会在创建或者更新记录的时候同时修改TIMESTAMP。
		 */
//		
		long ts1 = 1574208900000L;
		System.out.println(timestampToString(ts, Locale.CHINA, "Asia/Shanghai"));
		System.out.println(timestampToString(ts, Locale.US, "America/New_York"));

	}

	private static String timestampToString(long epochMilli, Locale lo, String zoneId) {
		Instant ins = Instant.ofEpochMilli(epochMilli);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
		return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));


	}

}
