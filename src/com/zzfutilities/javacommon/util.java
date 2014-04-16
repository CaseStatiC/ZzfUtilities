package com.zzfutilities.javacommon;

import java.util.List;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.util.Log;

public class util {
	/**
	 * x轴方向动画移动
	 */
	public void slideView(float p1, long duration) {
		Object o = null;
		ObjectAnimator mover = ObjectAnimator.ofFloat(o, "x", p1);
		mover.setDuration(duration);
		mover.start();
	}

	/**
	 * 获取一个包的启动acitivty
	 */
	public void getPackageInfo(Context context, String packStr) {
		PackageManager pm = context.getPackageManager();
		Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
		resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		try {
			PackageInfo pi = pm.getPackageInfo(packStr, 0);
			resolveIntent.setPackage(pi.packageName);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		List<ResolveInfo> apps = pm.queryIntentActivities(resolveIntent, 0);
		for (ResolveInfo r : apps) {
			String ss = r.activityInfo.name;
			Log.i("Reee", ss);
		}
	}
}
