package com.itranswarp.learnjava;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TimeFormatTest {

	@Test
	void testFormatSeconds() {
		assertEquals("06:40", TimeFormat.formatSeconds(400l));
		assertEquals("06:40", TimeFormat.formatSeconds(4000l));
		assertEquals("06:40", TimeFormat.formatSeconds(40000l));
		assertEquals("33:20", TimeFormat.formatSeconds(2000l));
		assertEquals("33:20", TimeFormat.formatSeconds(2000l));
	}

}
