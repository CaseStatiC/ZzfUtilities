package com.zzfutilities.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;

/**
 * 模拟导航菜单栏更多功能弹出框。设置模拟导航的消息发送的速度 (低速，中速和高速)。
 *
 * @author: zzf
 */
public class PopWindowMenu extends PopWindowDelayMiss implements
		OnClickListener {

	public PopWindowMenu(Context context) {
		super(context);
	}

	@Override
	public void onClick(View v) {
		dismiss();

	}

	@Override
	protected void initPopupWindow() {
		View mContentView = mInflater.inflate(1, null);

		setContentView(mContentView);
		setWidth(112);
		setHeight(LayoutParams.WRAP_CONTENT);
	}

	@Override
	protected void setDurationTime() {
		// TODO Auto-generated method stub

	}
}
