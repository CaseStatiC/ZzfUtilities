package com.zzfutilities.widget;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

/**
 *
 * 点击PopWindow范围内和外部不消失，设置时间来控制消失的Dialog
 */
public abstract class PopWindowDelayMiss extends PopupWindow {
	protected LayoutInflater	mInflater;

	protected int				mDurationTime	= 5000;

	private Handler				mHandler;
	private Runnable			mRunnable;

	public PopWindowDelayMiss(Context context) {
		super(context);
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		setBackgroundDrawable(null);
		initPopupWindow();
		setDurationTime();
		mHandler = new Handler();
		mRunnable = new Runnable() {

			@Override
			public void run() {
				PopWindowDelayMiss.this.dismiss();
			}
		};
	}

	protected abstract void setDurationTime();

	protected abstract void initPopupWindow();

	/**
	 * 点击按钮将弹出该PopWindow，过段时间将自动消失
	 *
	 * @param menuMoreView
	 *            被点击的View
	 */
	public void showAsDropDown(View anchor, int xoff, int yoff) {
		super.showAsDropDown(anchor, xoff, yoff);
		delayMiss();
	}

	private void delayMiss() {
		mHandler.removeCallbacks(mRunnable);
		mHandler.postDelayed(mRunnable, mDurationTime);
	}
}
