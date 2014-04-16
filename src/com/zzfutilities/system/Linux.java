package com.zzfutilities.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.util.Log;

public class Linux {
	/**
	 * 执行Linux命令并输出结果
	 */
	public void commandOutput() {
		final String TAG = "Commond";
		String cmd = "";
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(
					proc.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(
					proc.getErrorStream()));

			String s = null;
			while ((s = stdInput.readLine()) != null) {
				Log.i(TAG, s);
			}
			while ((s = stdError.readLine()) != null) {
				Log.i(TAG, s);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SecurityException();
		}
	}
/**
 * 获取root权限
 */
	public void getRoot() {
		try {
			Runtime.getRuntime().exec(
					new String[] { "/system/bin/su", "-c", "reboot now" });
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
