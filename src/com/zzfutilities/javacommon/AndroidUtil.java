package com.zzfutilities.javacommon;

import java.util.List;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class AndroidUtil {

	private Context		context;
	private Activity	activity;

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

	// http://stackoverflow.com/questions/1109022/close-hide-the-android-soft-keyboard
	public void hideKeyBoardAll(Context context, EditText myEditText) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
	}

	public void hideKeyBoard(Context context, EditText myEditText) {
		InputMethodManager imm = (InputMethodManager) context
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(myEditText.getWindowToken(),
				InputMethodManager.HIDE_IMPLICIT_ONLY);
	}

	public void getAndSetClickListenerViewById(Activity activity, int resID,
			OnClickListener listener) {
		View view = activity.findViewById(resID);
		view.setOnClickListener(listener);
	}

	public void startActivity() {
		// Intent intent = new Intent();
		// intent.setClass(context, cls);
		// startActivity(intent);
	}

	public void getScreenDimen() {
		Display display = activity.getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
	}

	public void getScreenDimens() {
		WindowManager wm = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
	}

	public void dip2px() {
		Resources r = context.getResources();
		float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14,
				r.getDisplayMetrics());
	}

}
