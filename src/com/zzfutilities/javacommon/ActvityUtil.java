package com.zzfutilities.javacommon;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;

public class ActvityUtil {
	private Activity	activity;

	public void setPortait() {
		activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}

	public void openUrlInBrowser() {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW,
				Uri.parse("http://www.google.com"));
		activity.startActivity(browserIntent);
	}

	public void putData() {
		Intent i = new Intent(activity, ActvityUtil.class);
		i.putExtra("new_variable_name", "value");
		activity.startActivity(i);
	}

	public void getData() {
		Bundle extras = activity.getIntent().getExtras();
		if (extras != null) {
			String value = extras.getString("new_variable_name");
		}
	}

}
