/*
 * DateUtil.java
 * 版权所有：江苏电力信息技术有限公司 2007 - 2012
 * 江苏电力信息技术有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.lhz.atom.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 将原有Utils中Date相关方法移入
 * 
 * @author Administrator
 * 
 */
public class DateUtil {

	public static final String defaultDatePattern = "yyyy-MM-dd";

	public static final String defaultDateTimePattern = "yyyy-MM-dd HH:mm:ss";

	public static final String defaultTimePattern = "HH:mm:ss";

	public static final String defaultDateTimeWithoutSecPattern = "yyyy-MM-dd HH:mm";

	/**
	 * 根据格式化模式，格式化日期类型
	 * 
	 * @param d
	 *            日期，如果是null，则默认之为当前日期
	 * @param pattern
	 *            模式，如果是null，则默认之为典型的年月日时分秒格式
	 * @return 以指定格式显示的日期字符串
	 */
	public static String formatDateTime(Date d, String pattern) {
		if (d == null) {
			d = new Date();
		}
		if (!StringUtil.availableStr(pattern)) {
			pattern = defaultDateTimePattern;
		}
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		String s = sf.format(d);
		return s;
	}

	public static String formatDateTime(Date d, String pattern, boolean nullable) {
		if (d == null) {
			return "";
		}
		if (!StringUtil.availableStr(pattern)) {
			pattern = defaultDateTimePattern;
		}
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		String s = sf.format(d);
		return s;
	}

	/**
	 * 用典型的年月日格式格式化模式，格式化日期类型
	 * 
	 * @param d
	 *            日期，如果是null，则默认之为当前日期
	 * @return 以典型的年月日格式格式显示的日期字符串
	 */
	public static String formatDate(Date d) {
		return formatDateTime(d, defaultDatePattern);
	}

	public static String formatDate(Date d, boolean nullable) {
		return formatDateTime(d, defaultDatePattern, nullable);
	}

	/**
	 * 用典型的年月日时分秒格式格式化模式，格式化日期类型
	 * 
	 * @param d
	 *            日期，如果是null，则默认之为当前日期
	 * @return 以典型的年月日时分秒格式格式显示的日期字符串
	 */
	public static String formatDateTime(Date d) {
		return formatDateTime(d, null);
	}

	/**
	 * 根据格式化模式，格式化当前日期类型
	 * 
	 * @param pattern
	 *            模式，如果是null，则默认之为典型的年月日时分秒格式
	 * @return 以指定格式显示的日期字符串
	 */
	public static String formatDateTime(String pattern) {
		return formatDateTime(null, pattern);
	}

	/**
	 * 用典型的年月日格式格式化模式，格式化当前日期
	 * 
	 * @return 以典型的年月日格式格式显示的日期字符串
	 */
	public static String formatDate() {
		return formatDateTime(null, defaultDatePattern);
	}

	/**
	 * 用典型的年月日时分秒格式格式化模式，格式化当前日期
	 * 
	 * @return 以典型的年月日时分秒格式格式显示的日期字符串
	 */
	public static String formatDateTime() {
		return formatDateTime(null, null);
	}

	/**
	 * 把一个日期时间转换为格式化的字符串，按照yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 *            要转换的日期时间
	 * @return 格式化后字符串，
	 */
	public static String formatDateTimeWithoutSecond(Date date) {
		return formatDateTime(date, defaultDateTimeWithoutSecPattern);
	}

	/**
	 * 按指定格式解析字符串，把它转化成Date对象,如果字符串没有值，返回null
	 * 
	 * @param dateTimeStr
	 * @param pattern
	 * @return
	 */
	public static Date parseDateTime(String dateTimeStr, String pattern) {
		if (!StringUtil.availableStr(dateTimeStr))
			return null;
		if (!StringUtil.availableStr(pattern)) {
			pattern = defaultDateTimePattern;
		}
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		try {
			return sf.parse(dateTimeStr);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 按yyyy-MM-dd HH:mm:ss解析字符串，把它转化成Date对象,如果字符串没有值，返回null
	 * 
	 * @param dateTimeStr
	 * @return
	 */
	public static Date parseDateTime(String dateTimeStr) {
		return parseDateTime(dateTimeStr, null);
	}

	/**
	 * 按yyyy-MM-dd HH:mm:ss解析字符串，把它转化成Date对象,如果字符串没有值，返回null
	 * 
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate(String dateStr) {
		return parseDateTime(dateStr, defaultDatePattern);
	}

	/**
	 * 取本周的第一天
	 * 
	 * @param d
	 * @return
	 */
	public static Date getFirstDayOfWeek(Date d) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(d);
		c.set(Calendar.DAY_OF_WEEK, 1);
		return c.getTime();
	}

	/**
	 * 取本周的最后一天
	 * 
	 * @param d
	 * @return
	 */
	public static Date getLastDayOfWeek(Date d) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(d);
		c.set(Calendar.DAY_OF_WEEK, 7);
		return c.getTime();
	}

	/**
	 * 取上周的第一天
	 * 
	 * @param d
	 * @return
	 */
	public static Date getFirstDayOfLastWeek(Date d) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(d);
		if (1 == c.get(Calendar.DAY_OF_WEEK)) {
			c.add(Calendar.DAY_OF_MONTH, -13);
			return c.getTime();
		}
		c.add(Calendar.DAY_OF_MONTH, -7);
		c.set(Calendar.DAY_OF_WEEK, 2);
		return c.getTime();
	}

	/**
	 * 取上周的最后一天
	 * 
	 * @param d
	 * @return
	 */
	public static Date getLastDayOfLastWeek(Date d) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(d);
		if (1 == c.get(Calendar.DAY_OF_WEEK)) {
			c.add(Calendar.DAY_OF_MONTH, -7);
			return c.getTime();
		}
		c.add(Calendar.DAY_OF_MONTH, -7);
		c.set(Calendar.DAY_OF_WEEK, 2);
		c.add(Calendar.DAY_OF_MONTH, 6);
		return c.getTime();
	}

	/**
	 * 取本月第一天
	 * 
	 * @param d
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date d) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(d);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	/**
	 * 获得当前月份的最后第一天。
	 * 
	 * @return 当前月份的最后第一天。
	 */
	public static Date getLastDayOfMonth(Date d) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(d);
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		int maxDaysOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		c.add(Calendar.DAY_OF_MONTH, maxDaysOfMonth - dayOfMonth);
		return c.getTime();
	}

	/**
	 * 取本年第一天
	 * 
	 * @param d
	 * @return
	 */
	public static Date getFirstDayOfYear(Date d) {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(d);
		c.set(Calendar.DAY_OF_YEAR, 1);
		return c.getTime();
	}

	/**
	 * 取当前日期，时、分、秒、毫秒部分设置为0
	 * 
	 * @return 当前日期
	 */
	public static java.util.Date getCurrentDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 取当前日期并转化为格式为:yyyy-MM-dd的字符串,时、分、秒、毫秒部分设置为0
	 * 
	 * @return 当前时间按照yyyy-MM-dd格式化的字符串
	 */
	public static String getCurrentDateAsString() {
		Calendar cal = Calendar.getInstance();
		return formatDate(cal.getTime());
	}

	/**
	 * 获得当前的系统时间，毫秒设置为0。
	 * 
	 * @return 当前时间精确到秒，不包括日期部分。
	 */
	public static java.sql.Time getCurrentTime() {
		Calendar cal = Calendar.getInstance();
		System.err.println(TimeZone.getDefault());
		cal.set(Calendar.MILLISECOND, 0);
		return new java.sql.Time(cal.getTime().getTime());
	}

	/**
	 * 获得当前的系统时间，毫秒设置为0，并格式化为字符串。
	 * 
	 * @return 当前时间的字符串表示，精确到秒，不包括日期部分。
	 */
	public static String getCurrentTimeAsString() {
		java.sql.Time time = getCurrentTime();
		return formatDateTime(time, defaultTimePattern);
	}

	/**
	 * 获得当前的系统时间，秒、毫秒设置为0。
	 * 
	 * @return 当前时间精确到秒，不包括日期部分。
	 */
	public static java.sql.Time getCurrentTimeWithoutSecond() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return new java.sql.Time(cal.getTime().getTime());
	}

	/**
	 * 获得当前的系统时间，毫秒设置为0，并格式化为字符串。
	 * 
	 * @return 当前时间的字符串表示，精确到秒，不包括日期部分。
	 */
	public static String getCurrentTimeWithoutSecondAsString() {
		java.sql.Time time = getCurrentTimeWithoutSecond();
		return formatDateTime(time, defaultDateTimeWithoutSecPattern);
	}

	/**
	 * 获得当前的系统时间，毫秒设置为0。
	 * 
	 * @return 当前时间，精确到秒。
	 */
	public static Timestamp getCurrentTimestamp() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MILLISECOND, 0);
		return new Timestamp(cal.getTime().getTime());
	}

	/**
	 * 获得当前的系统时间，毫秒设置为0，并格式化为字符串。
	 * 
	 * @return 当前时间的字符串表示，精确到秒。
	 */
	public static String getCurrentTimestampAsString() {
		Timestamp timestamp = getCurrentTimestamp();
		return formatDateTime(timestamp);
	}

	/**
	 * 获得当前的系统时间，秒、毫秒设置为0。
	 * 
	 * @return 当前时间精确到分钟。
	 */
	public static Timestamp getCurrentTimestampWithoutSecond() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return new Timestamp(cal.getTime().getTime());
	}

	/**
	 * 获得当前的系统时间，秒、毫秒设置为0，并格式化为字符串。
	 * 
	 * @return 当前时间的字符串表示精确到分钟。
	 */
	public static String getCurrentTimestampWithoutSecondAsString() {
		Timestamp timestamp = getCurrentTimestampWithoutSecond();
		return formatDateTimeWithoutSecond(timestamp);
	}

	/**
	 * 取当前年份
	 * 
	 * @return int
	 */
	public static int getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	/**
	 * 取当前月份
	 * 
	 * @return int
	 */
	public static int getCurrentMonth() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * 取得当前是星期几 星期一为第一天返回1,星期天返回0
	 * 
	 * @return
	 */
	public static int getCurrentWeekDay() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 取得当前秒
	 * 
	 * @return
	 */
	public static int getCurrentSecond() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * 取得当前分
	 * 
	 * @return
	 */
	public static int getCurrentMinute() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * 取得当前小时
	 * 
	 * @return
	 */
	public static int getCurrentHour() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * 取得当前天
	 * 
	 * @return
	 */
	public static int getCurrentDay() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 从Timestamp获得日期值
	 * 
	 * @param timestamp
	 * @return 去掉时间后的日期
	 */
	public static java.util.Date getDate(Timestamp timestamp) {
		if (timestamp != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(timestamp);
			cal.set(Calendar.HOUR, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			return new java.sql.Date(cal.getTime().getTime());
		}
		return null;
	}

	/**
	 * 获得当前月份的第一天。
	 * 
	 * @return 当前月份的第一天。
	 */
	public static java.sql.Date getFirstDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		return new java.sql.Date(cal.getTime().getTime());
	}

	/**
	 * 获得当前月份的第一天并且按照yyyy-MM-dd格式化为字符串
	 * 
	 * @return 当前月份的第一天按照yyyy-MM-dd格式化的字符串
	 */
	public static String getFirstDayOfMonthAsString() {
		java.sql.Date date = getFirstDayOfMonth();
		return formatDate(date);
	}

	/**
	 * 获得当前月份的最后第一天。
	 * 
	 * @return 当前月份的最后第一天。
	 */
	public static java.sql.Date getLastDayOfMonth() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, 1);
		cal.roll(Calendar.MONTH, true);
		cal.roll(Calendar.DATE, false);
		return new java.sql.Date(cal.getTime().getTime());
	}

	/**
	 * 获得当前月份的最后一天并且按照yyyy-MM-dd格式化为字符串
	 * 
	 * @return 当前月份的最后一天按照yyyy-MM-dd格式化的字符串
	 */
	public static String getLastDayOfMonthAsString() {
		java.sql.Date date = getLastDayOfMonth();
		return formatDate(date);
	}

	public static String toString(Date date, String format) {

		SimpleDateFormat formatter;

		if ((date == null) || (format == null) || (format.length() == 0)) {
			return null;
		}
		formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
	
	/**
	 * 计算时间差，换算成分钟
	 * @param endDate
	 * @param nowDate
	 * @return
	 */
	public static long getDatePoor(Date endDate, Date nowDate) {

		long nd = 1000 * 24 * 60 * 60;

		long nh = 1000 * 60 * 60;

		long nm = 1000 * 60;

		// long ns = 1000;

		// 获得两个时间的毫秒时间差异

		long diff = endDate.getTime() - nowDate.getTime();

		// 计算差多少天

		long day = diff / nd;

		// 计算差多少小时

		long hour = diff % nd / nh;

		// 计算差多少分钟

		long min = diff / nm;

		// 计算差多少秒//输出结果

		// long sec = diff % nd % nh % nm / ns;
		
		return min;

		}


}
