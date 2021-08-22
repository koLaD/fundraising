package com.fundraising.util.common;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CommonUtil {

	public static String changeDateToString(String format, Date date) {
		if (date == null) {
			return null;
		}

		if (format == null || format.trim().isEmpty()) {
			format = CommonConstant.STD_DATE_TIME_FORMAT;
		}

		return new SimpleDateFormat(format).format(date);
	}

	public static boolean isValidLong(Long value) {
		if (value != null && value.longValue() > 0)
			return true;
		return false;
	}

	public static boolean isValidInteger(Integer value) {
		if (value != null && value.intValue() > 0)
			return true;
		return false;
	}

	public static boolean isValidString(String value) {
		if (value != null && value.trim() != "")
			return true;
		return false;
	}

	public static boolean isNullOrZero(BigDecimal bigdecimal) {
		if (bigdecimal == null || bigdecimal.longValue() <= 0)
			return true;
		return false;
	}

	public static boolean isNullOrEmpty(String string) {
		if (string == null || string.equals(""))
			return true;
		return false;
	}
	
	public static boolean isValidList(List value) {
		if (value != null && value.size() > 0)
			return true;
		return false;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isNullOrEmpty(List value) {
		if (value == null || value.isEmpty())
			return true;
		return false;
	}

}
