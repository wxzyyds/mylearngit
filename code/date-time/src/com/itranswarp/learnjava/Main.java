package com.itranswarp.learnjava;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;


/**
 * @author wxz
 * 计算机中处理时间和日期
 * 
 * 日期是某一天，不连续变化是离散的
 * 
 * 时间有两种概念：带日期的，和不带日期的 
 * 
 * 本地时间：国内就是北京时间，全球一共分为24个时区，
 * 伦敦所在的时区称为标准时区，
 * 其他时区按东／西偏移的小时区分，
 * 北京所在的时区是东八区。
 * 
 * 时区：
 * 1.一种是以GMT或者UTC加时区偏移表示，例如：GMT+08:00或者UTC+08:00表示东八区。
 * UTC使用更精确的原子钟计时，发程序的时候可以忽略。
 * 计算机的时钟在联网的时候会自动与时间服务器同步时间。
 * 
 * 2.另一种是缩写，例如，CST表示China Standard Time，也就是中国标准时间。
 * CST也可以表示美国中部时间Central Standard Time USA，缩写容易产生混淆，尽量不用缩写
 * 
 * 3.一种是以洲／城市表示，例如，Asia/Shanghai，表示上海所在地的时区。
 * 特别注意城市名称不是任意的城市，而是由国际标准组织规定的城市。
 * 
 * 分别在两个时区的两个人，在这一刻通电话各自报出手表时间，本地时间是不同的，时刻是相同的。
 * 
 * 夏令时:
 * 夏令时，就是夏天开始的时候，把时间往后拨1小时，夏天结束的时候，再把时间往前拨1小时。
 * 
 * 计算夏令时，没有统一的公式，必须按照一组给定的规则来算，并且，该规则要定期更新。
 * 实行夏令时的不同地区，进入和退出夏令时的时间很可能是不同的。
 * 同一个地区，根据历史上是否实行过夏令时，标准时间在不同年份换算成当地时间也是不同的。
 * 
 * 本地化：
 * 通常使用Locale表示一个国家或地区的日期、时间、数字、货币等格式。
 * Locale由语言_国家的字母缩写构成，zh_CN：中国，en_US美国.语言使用小写，国家使用大写。
 * 
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		/*
		 * 某航线从北京飞到纽约需要13小时20分钟，请根据北京起飞日期和时间计算到达纽约的当地日期和时间。
		 */

        LocalDateTime departureAtBeijing = LocalDateTime.of(2019, 9, 15, 13, 0, 0);
        int hours = 13;
        int minutes = 20;
        LocalDateTime arrivalAtNewYork = calculateArrivalAtNY(departureAtBeijing, hours, minutes);
        System.out.println(departureAtBeijing + " -> " + arrivalAtNewYork);
        // test:
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }
	}

	private static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
		
		// TODO  转换时区  计算飞机到纽约后，纽约时间。
		ZonedDateTime zny = bj.atZone(ZoneId.of("Asia/Shanghai"));
		ZonedDateTime zdy = zny.withZoneSameInstant(ZoneId.of("America/New_York"));		
		return zdy.toLocalDateTime().plusMinutes(m).plusHours(h);
	}


	
	

}
