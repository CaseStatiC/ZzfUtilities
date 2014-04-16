package com.zzfutilities.javacommon;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;

public class TwoDrawableToOne {

	public static Bitmap merger(Bitmap bkDrawable, Bitmap arrowDrawable) {

		if (bkDrawable == null || arrowDrawable == null)
			return null;

		Bitmap result = Bitmap.createBitmap(bkDrawable.getWidth(),
				bkDrawable.getHeight(), Config.ARGB_8888);

		int toCovert = arrowDrawable.getPixel(10, 10);

		arrowDrawable = arrowDrawable.copy(Bitmap.Config.ARGB_8888, true);
		arrowDrawable.setHasAlpha(true);

		int[] argb = new int[arrowDrawable.getWidth()
				* arrowDrawable.getHeight()];
		arrowDrawable.getPixels(argb, 0, arrowDrawable.getWidth(), 0, 0,
				arrowDrawable.getWidth(), arrowDrawable.getHeight());

		for (int x = 0; x < argb.length; x++) {
			if (argb[x] == toCovert) {
				argb[x] = 0;
			}
		}
		arrowDrawable = Bitmap.createBitmap(argb, arrowDrawable.getWidth(),
				arrowDrawable.getHeight(), Config.ARGB_8888);

		Canvas c = new Canvas(result);
		c.drawBitmap(bkDrawable, 0, 0, null);
		c.drawBitmap(arrowDrawable, 0, 0, null);
		c.save();
		c.restore();

		return result;
	}

}
