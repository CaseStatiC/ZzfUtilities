package com.zzfutilities.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * 在onTouch前截获touch事件的Layout
 *
 */
public class InterceptTouchEventLayout extends FrameLayout {

	public InterceptTouchEventLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public InterceptTouchEventLayout(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// 事件处理
		boolean x =false;
		if (x) {
			return true;
		}
		return false;
	}
}