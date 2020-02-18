package com.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * @author shahzad.hussain
 *
 */
public final class DateUtil {

	public static Date parseDate(String date, String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		sdf.setLenient(false);
		return sdf.parse(date);
	}

	public static LocalDate parseLocalDate(String date, String format) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
			return LocalDate.parse(date, formatter);

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static String format(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static String formatLocalDate(LocalDate date, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return formatter.format(date);
	}

	public static Date getDateFromMillis(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	public static Date getDateBeforeXDays(Date date, int getDateBeforeXDays) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -getDateBeforeXDays);
		return c.getTime();
	}

	public static LocalDate getLocalDateFromInstant(Integer emiDay) {
		return LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), emiDay).plusMonths(1);
	}

	public static String getLocalDateToString(LocalDate localDate, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return localDate.format(formatter);
	}

	public static String getLocalDateTimeToString(LocalDateTime localDate, String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return localDate.format(formatter);
	}

	public static String getDateToString(Date date, String format) {
		DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.format(date);
	}

	public static long getDaysFromLocalDatedifference(LocalDate fromDate, LocalDate toDate) {
		try {
			return ChronoUnit.DAYS.between(fromDate, toDate) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String getLocalTimeToString(LocalTime time, String formatter) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formatter);
		return time.format(format);
	}

	public static LocalTime getStringToLocalTime(String time, String formatter) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formatter);
		return LocalTime.parse(time, format);
	}

	public static boolean isSecondOrFourthSaturday(LocalDate date) {
		WeekFields weekFields = WeekFields.of(Locale.getDefault());
		int weekNumber = date.get(weekFields.weekOfMonth());
		if (weekNumber == 1 || weekNumber == 3) {
			return true;
		}
		return false;
	}

	public static Date instantToDate(Instant instant) {
		return Date.from(instant);
	}

	public static String getDateFromInstant(Instant instantDate, String format) {
		LocalDateTime datetime = LocalDateTime.ofInstant(instantDate, ZoneOffset.UTC);
		return DateTimeFormatter.ofPattern(format).format(datetime);
	}

	public static long daysBetweenDates(Date d1, Date d2) {
		Instant instant1 = d1.toInstant();
		Instant instant2 = d2.toInstant();
		long diff = ChronoUnit.DAYS.between(instant1, instant2);
		return diff;
	}

}
