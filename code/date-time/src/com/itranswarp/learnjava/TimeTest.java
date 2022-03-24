package com.itranswarp.learnjava;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author wxz 从Java 8开始，java.time包提供了新的日期和时间API，主要涉及的类型有：
 *         本地日期和时间：LocalDateTime，LocalDate，LocalTime； 带时区的日期和时间：ZonedDateTime；
 *         时刻：Instant； 时区：ZoneId，ZoneOffset； 时间间隔：Duration。
 *         以及一套新的用于取代SimpleDateFormat的格式化类型DateTimeFormatter。
 * 
 *         新的java.util.time的工具。 其API严格规定 时刻， 本地日期， 本地时间和 带时区的日期时间 也提供了更方便的运算方法
 *         Month的范围用1~12表示1月到12月；和Date中0开始不同 Week的范围用1~7表示周一到周日。和Date中0开始不同
 */
public class TimeTest {

	public static void main(String[] args) {

//		getLocalDateTime();//多个对象会导致时间不精确
//		获取更精确的DateTime，仅使用一个LocalDate对象;通过now()
//		getSureLocalDateTime();

//		通过of(int,int,int)指定时间日期并打印
//		getCustomDateTime();

//		严格按照ISO 8601的格式，因此，将字符串转换为LocalDateTime就可以传入标准格式：通过parse(String)
//		getStringToLocalDateTime();

//		自定义输出格式 DateTimeFormatter.ofPattern(Locale)
//		自定义解析格式 LocalDateTime.parse(now, dtf);
//		getDateTimeFormatter();

//		LocalDateTime提供的链式调用,来操作加减日期 plusDays  minusHours
//		getChainedCalls();

//		指定修改方法 withYear() withMonth() withDayOfMonth() withHour() withMinutes() withSecond()
//		getChangeTimeMethod();

//		自定义修改 通用的with()方法允许我们做更复杂的运算,
//		对于计算某个月第1个周日这样的问题，新的API可以轻松完成。
//		getWith();

//		判断两个LocalDateTime的先后，可以使用isBefore()、isAfter()方法，对于LocalDate和LocalTime类似：
//		adjustTime();

//		Duration和Period,P...T之间表示日期间隔，T后面表示时间间隔。
//		Duration表示两个时刻之间的时间间隔。
		getDuration();
//		另一个类似的Period表示两个日期之间的天数：
		getPeriod();
		
//		利用ofXxx()或者parse()方法也可以直接创建Duration
		createDuration();

	}

	private static void createDuration() {
		// TODO Auto-generated method stub
		Duration d1 = Duration.ofHours(10); // 10 hours
		Duration d2 = Duration.parse("P1DT2H3M");// 1 day, 2 hours, 3 minutes
		System.err.println("d1"+d1+"---------d2"+d2);
	}

	private static void getPeriod() {
		// TODO 计算两个日期的天数间隔
		Period p = LocalDate.of(2019, 11, 19).until(LocalDate.of(2020, 1, 9));
		System.out.println(p); // P1M21D表示1个月21天。符合ISO 8601的格式
	}

	private static void getDuration() {
		// TODO 计算两个日期的时刻间隔时常
		LocalDateTime start = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
		LocalDateTime end = LocalDateTime.of(2020, 1, 9, 19, 25, 30);
		Duration d = Duration.between(start, end);
		System.out.println("计算两个日期的时刻间隔时常" + d); // PT1235H10M30S表示1235小时10分钟30秒

	}

	private static void adjustTime() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime target = LocalDateTime.of(2019, 11, 19, 8, 15, 0);
		System.out.println(now.isBefore(target));
		System.out.println(LocalDate.now().isBefore(LocalDate.of(2019, 11, 19)));
		System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));

	}

	private static void getDateTimeFormatter() {
		// TODO DateTimeFormatter.ofPattern

		// 自定义格式化:
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		String now = dtf.format(LocalDateTime.now());
		System.out.println(now);

		// 用自定义格式解析:
		LocalDateTime dt2 = LocalDateTime.parse(now, dtf);
		System.out.println(dt2);

	}

	private static void getStringToLocalDateTime() {
		/*
		 * 注意ISO 8601规定的日期和时间分隔符是T。标准格式如下： 日期：yyyy-MM-dd 时间：HH:mm:ss 带毫秒的时间：HH:mm:ss.SSS
		 * 日期和时间：yyyy-MM-dd'T'HH:mm:ss 带毫秒的日期和时间：yyyy-MM-dd'T'HH:mm:ss.SSS
		 */
		LocalDateTime dt = LocalDateTime.parse("2019-11-19T15:16:17");
		LocalDate d = LocalDate.parse("2019-11-19");
		LocalTime t = LocalTime.parse("15:16:17");
		System.out.println(d); // 严格按照ISO 8601格式打印
		System.out.println(t); // 严格按照ISO 8601格式打印
		System.out.println(dt); // 严格按照ISO 8601格式打印
	}

	public static void getLocalDateTime() {
		LocalDate d = LocalDate.now(); // 当前日期
		LocalTime t = LocalTime.now(); // 当前时间
		LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
		System.out.println(d); // 严格按照ISO 8601格式打印
		System.out.println(t); // 严格按照ISO 8601格式打印
		System.out.println(dt); // 严格按照ISO 8601格式打印
	}

	public static void getSureLocalDateTime() {
		LocalDateTime dt = LocalDateTime.now(); // 当前日期和时间
		LocalDate d = dt.toLocalDate(); // 转换到当前日期
		LocalTime t = dt.toLocalTime(); // 转换到当前时间
		System.out.println(d); // 严格按照ISO 8601格式打印
		System.out.println(t); // 严格按照ISO 8601格式打印
		System.out.println(dt); // 严格按照ISO 8601格式打印
	}

//	通过LocalDate、LocalTime、LocalDateTime的of()方法自定义时间
	public static void getCustomDateTime() {
		// 指定日期和时间:
		LocalDate d2 = LocalDate.of(2019, 11, 30); // 2019-11-30, 注意11=11月
		LocalTime t2 = LocalTime.of(15, 16, 17); // 15:16:17
		LocalDateTime dt2 = LocalDateTime.of(2019, 11, 30, 15, 16, 17);
		LocalDateTime dt3 = LocalDateTime.of(d2, t2);
		System.out.println(d2); // 严格按照ISO 8601格式打印
		System.out.println(t2); // 严格按照ISO 8601格式打印
		System.out.println(dt2); // 严格按照ISO 8601格式打印
		System.out.println(dt3); // 严格按照ISO 8601格式打印
	}

	public static void getChainedCalls() {

		LocalDateTime dt = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(),
				LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(),
				LocalDateTime.now().getSecond());
		System.out.println(dt);
		// 加5天减3小时:
		LocalDateTime dt2 = dt.plusDays(5).minusHours(3);
		System.out.println(dt2); // 2019-10-31T17:30:59
		// 减1月:
		LocalDateTime dt3 = dt2.minusMonths(1);
		System.out.println(dt3); // 2019-09-30T17:30:59
	}

	public static void getChangeTimeMethod() {
		LocalDateTime dt = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), 31,
				LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println(dtf.format(dt));
		// 调整年：withYear()
		System.out.println(dtf.format(dt.withYear(2023)));
		// 调整月：withMonth()
		System.out.println(dt.withMonth(2));
		// 调整日：withDayOfMonth()
		System.out.println(dt.withDayOfMonth(28));
		// 调整时：withHour()
		System.out.println(dt.withHour(12));
		// 调整分：withMinute()
		System.out.println(dt.withMinute(12));
		// 调整秒：withSecond()
		System.out.println(dt.withSecond(12));
	}

	public static void getWith() {
		// 本月第一天0:00时刻:
		LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
		System.out.println("本月第一天---" + firstDay);
		// 本月第最后一天:
		LocalDate lastDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("本月最后一天---" + lastDay);

		// 下月第1天:

		LocalDateTime firstDayOfNextMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfNextMonth())
				.atStartOfDay();
		System.out.println("下月第1天---" + firstDayOfNextMonth);

		// 本月第1个周一:
		LocalDateTime firstDayOfWeek = LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY))
				.atStartOfDay();
		System.out.println("本月第1个周一---" + firstDayOfWeek);
	}

}
