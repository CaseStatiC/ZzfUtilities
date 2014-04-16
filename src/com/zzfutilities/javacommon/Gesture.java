package com.zzfutilities.javacommon;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

//http://stackoverflow.com/questions/937313/android-basic-gesture-detection
public class Gesture extends Activity implements OnClickListener {

	private static final int	SWIPE_MIN_DISTANCE			= 120;
	private static final int	SWIPE_MAX_OFF_PATH			= 250;
	private static final int	SWIPE_THRESHOLD_VELOCITY	= 200;
	private GestureDetector		gestureDetector;
	View.OnTouchListener		gestureListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gestureDetector = new GestureDetector(this, new MyGestureDetector());
		gestureListener = new View.OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event);
			}
		};

		// imageView.setOnClickListener(Gesture.this);
		// imageView.setOnTouchListener(gestureListener);
	}

	class MyGestureDetector extends SimpleOnGestureListener {
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			try {
				if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
					return false;
				// right to left swipe
				if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE
						&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					Toast.makeText(Gesture.this, "Left Swipe",
							Toast.LENGTH_SHORT).show();
				} else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE
						&& Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
					Toast.makeText(Gesture.this, "Right Swipe",
							Toast.LENGTH_SHORT).show();
				}
			} catch (Exception e) {
				// nothing
			}
			return false;
		}

		@Override
		public boolean onDown(MotionEvent e) {
			return true;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}