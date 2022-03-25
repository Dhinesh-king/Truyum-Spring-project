package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This method is used to convert date entered in a form to be converted into a
 * Date object. 1. Using SimpleDateFormat and parse() method convert the input
 * String in �dd/MM/yyyy� format into java.util.Date type.
 */
public class DateUtil {
	public static Date convertToDate(String date) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date actualDate = null;
		try {
			actualDate = format.parse(date);
		} catch (ParseException e) {
			System.err.println("An Exxception occured during the parsing of the Date ");
		}
		return actualDate;
	}
	public static String convertToString(Date date) {
		long year=date.getYear()+1900;
		String dateString=date.getDate()+"/"+date.getMonth()+"/"+year;
		return dateString;	
	}
	private DateUtil() {
		super();
		throw new IllegalStateException("Utility class");
	}
}
