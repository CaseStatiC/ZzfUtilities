package com.zzfutilities.javacommon;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
import android.text.format.Time;

public class TimeUtil {
	@SuppressLint("SimpleDateFormat")
	public static String formatCurrentTime() {
		Date date = new Date();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFormatted = formatter.format(date);
		return dateFormatted;
	}

	@SuppressLint("SimpleDateFormat")
	public static String fomatTime(long currentTime) {
		Date date = new Date(currentTime);
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateFormatted = formatter.format(date);
		return dateFormatted;
	}

	@SuppressLint("SimpleDateFormat")
	public static Date parseStr2Date(String myStr) {// 将字符串转为日期
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date date = null;
		try {
			date = format.parse(myStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public void getTime() {
		Calendar c = Calendar.getInstance();
		int seconds = c.get(Calendar.SECOND);

		Time now = new Time();
		now.setToNow();
	}
}
