package com.itranswarp.learnjava;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author wxz 单元测试 编写接口 │ ▼ 编写测试 │ ▼ ┌─> 编写实现 │ │ │ N ▼ └── 运行测试 │ Y ▼ 任务完成
 *         这就是TDD
 *
 *         然而，大部分情况是已经编写好代码，并对已有代码进行测试
 */
public class TimeFormat  {

	public static void main(String[] args) {
		long seconds = 20000000l;
		System.out.println(formatSeconds(seconds));
		if (formatSeconds(seconds).equals("06:40")) {
			System.out.println("pass");
		} else {
			System.out.println("fail");

		}
	}

	/**
	 * 
	 * @param seconds
	 * @return String 
	 */
	static String formatSeconds(long seconds) {
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("mm:ss");
		LocalDateTime time = LocalDateTime.ofInstant(Instant.ofEpochSecond(seconds), ZoneId.systemDefault());
		return time.format(timeFormatter);
	}

}
