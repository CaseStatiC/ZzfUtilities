package com.zzfutilities.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
//android:theme="@android:style/Theme.NoTitleBar" 没有标题
//   android:theme="@android:style/Theme.NoTitleBar.Fullscreen" >全屏

public class NoTitleActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Remove title bar
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		// Remove notification bar
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// set content view AFTER ABOVE sequence (to avoid crash)
		// this.setContentView(R.layout.your_layout_name_here);
	}
}
