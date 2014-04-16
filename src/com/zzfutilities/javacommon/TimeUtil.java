package com.zzfutilities.javacommon;

import android.annotation.SuppressLint;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
}
