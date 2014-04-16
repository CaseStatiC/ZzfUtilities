package com.zzfutilities.widget;

import android.content.Context;
import android.widget.FrameLayout;
/**
 * 一个透明的布局，用来辅助处理事件处理
 */
public class TransparentLayout extends FrameLayout {

	public TransparentLayout(Context context) {
		super(context);
		setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT));
	}

}
