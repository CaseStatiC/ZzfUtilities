package com.zzfutilities.cocurrent;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
/**
 * 在activity生命周期执行的Timer
 */
public class ActivityTimer {
	private Activity	mActivity;
	private Timer		myTimer;
	private Runnable	Timer_Tick	= new Runnable() {
										@Override
										public void run() {
											// Toast.makeText(mActivity,
											// "No task tu schdule",
											// Toast.LENGTH_LONG).show();
										}
									};

	public ActivityTimer(Activity activity, long period) {
		mActivity = activity;
		myTimer = new Timer();

		myTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				TimerMethod();
			}

		}, 0, period);
	}

	private synchronized void TimerMethod() {
		mActivity.runOnUiThread(Timer_Tick);
	}

	public synchronized void setSchduleRunnable(Runnable runnable) {
		Timer_Tick = runnable;
	}
}
