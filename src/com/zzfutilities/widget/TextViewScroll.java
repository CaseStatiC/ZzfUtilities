package com.zzfutilities.widget;

import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class TextViewScroll {

	// android:maxLines = "AN_INTEGER"
	//
	// android:scrollbars = "vertical"
	// properties of your TextView in your layout's xml file.

	public void setScroll() {
		TextView v = null;
		v.setMovementMethod(new ScrollingMovementMethod());
	}

}
