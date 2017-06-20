package com.agit.crm.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @author bitozen
 */
public final class DateUtil {
    public final static String TIMEZONE = "GMT+7:00";
    static final long ONE_DAY_IN_MILL_SEC = 86400000;
    
    /**
     * Format => "dd-MM-yyyy" or "HH : mm" or others
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateToString(Date date, String format) {
        if (date == null) {
            return "-";
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * Format => "dd-MM-yyyy" or "HH : mm" or others
     *
     * @param dateString
     * @param format
     * @return
     */
    public static Date stringToDate(String dateString, String format) {
        try {
            return (new SimpleDateFormat(format)).parse(dateString);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * DatewithoutTime => "21-Oct-2015 12:34:12" => "21-Oct-2015 00:00:00"
     *
     * @param date
     * @return
     */
    public static Date getDateWithoutTime(Date date) {
        if (date == null) {
            return null;
        }
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * EndOfDay => "21-Oct-2015 23:59:59"
     *
     * @param date
     * @return
     */
    public static Date getEndOfDay(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = GregorianCalendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DATE, 1);
        cal.add(Calendar.MILLISECOND, -1);

        return cal.getTime();
    }

    /**
     * addDay (1) => "31-Oct-2015 12:34:12" => "01-Nov-2015 12:34:12" minusDay
     * (-1) => "01-Oct-2015 12:34:12" => "30-Sep-2015 12:34:12"
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    /**
     * @param date
     * @param months
     * @return
     */
    public static Date addMonths(Date date, int months) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months); //minus number would decrement the days
        return cal.getTime();
    }

    /**
     * @param date
     * @param years
     * @return
     */
    public static Date addYears(Date date, int years) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years); //minus number would decrement the days
        return cal.getTime();
    }

    /**
     * different between two Date/Time
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int getDays(Date startDate, Date endDate) {
        int diff = (int) ((DateUtil.getDateWithoutTime(endDate).getTime() - DateUtil.getDateWithoutTime(startDate).getTime()) / (1000 * 60 * 60 * 24));
        return diff;
    }

    public static Date getDate(Date dates) {
        Calendar cal = GregorianCalendar.getInstance();
        if (dates == null) {
            return new Date();
        } else {
            cal.setTime(dates);
            return cal.getTime();
        }
    }
    
    public static Date toDate(final String date) {
        return toDate(date, "00:00.00.000");
    }
    
    public static Date toDate(final String date, final String time) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date + " " + time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static Date add(final Date a, int b){
        Calendar cal_a = GregorianCalendar.getInstance();
        cal_a.setTime(a);
        cal_a.add(Calendar.DAY_OF_MONTH, b);
        String s = dateToString(cal_a.getTime(),"yyyy-MM-dd");
        return toDate(s);
    }
    
    public static boolean isAfter(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		int day1 = cal1.get(Calendar.DAY_OF_MONTH);
		int month1 = cal1.get(Calendar.MONTH);
		int year1 = cal1.get(Calendar.YEAR);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day2 = cal2.get(Calendar.DAY_OF_MONTH);
		int month2 = cal2.get(Calendar.MONTH);
		int year2 = cal2.get(Calendar.YEAR);

		if (year1 < year2) { // check year
			return true;
		} else if (year1 == year2) { // if year is equal
			if (month1 < month2) { // check month
				return true;
			} else if (month1 == month2) { // if month is equal
				if (day1 < day2) { // check day
					return true;
				}
			}
		}
		return false;
	}
    
    public static boolean isEqual(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		int day1 = cal1.get(Calendar.DAY_OF_MONTH);
		int month1 = cal1.get(Calendar.MONTH);
		int year1 = cal1.get(Calendar.YEAR);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day2 = cal2.get(Calendar.DAY_OF_MONTH);
		int month2 = cal2.get(Calendar.MONTH);
		int year2 = cal2.get(Calendar.YEAR);

		return ((day1 == day2) && (month1 == month2) && (year1 == year2));
	}
    
    public static Date getDateMinusDay(Date d, int days) {
		return (new Date(d.getTime() - days * ONE_DAY_IN_MILL_SEC));
	}
    
    public static Date getNextDate(Date date, int days) {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
    
}
