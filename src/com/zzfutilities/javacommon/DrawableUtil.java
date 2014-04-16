package com.zzfutilities.javacommon;

import java.io.File;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class DrawableUtil {

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

	public static Bitmap drawableToBitmap(Drawable drawable) {
		if (drawable instanceof BitmapDrawable) {
			return ((BitmapDrawable) drawable).getBitmap();
		}

		Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
				drawable.getIntrinsicHeight(), Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
		drawable.draw(canvas);

		return bitmap;
	}

	public void getBitmapFromPhoto() {

		// Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		// photoPickerIntent.setType("image/*");
		// startActivityForResult(photoPickerIntent, SELECT_PHOTO);

		// protected void onActivityResult(int requestCode, int resultCode,
		// Intent imageReturnedIntent) {
		// super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
		//
		// switch(requestCode) {
		// case REQ_CODE_PICK_IMAGE:
		// if(resultCode == RESULT_OK){
		// Uri selectedImage = imageReturnedIntent.getData();
		// String[] filePathColumn = {MediaStore.Images.Media.DATA};
		//
		// Cursor cursor = getContentResolver().query(
		// selectedImage, filePathColumn, null, null, null);
		// cursor.moveToFirst();
		//
		// int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
		// String filePath = cursor.getString(columnIndex);
		// cursor.close();
		//
		//
		// Bitmap yourSelectedImage = BitmapFactory.decodeFile(filePath);
		// }
		// }
	}

	public void saveBitmap(Bitmap bmp) {
		File finename = null;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(finename);
			bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (Throwable ignore) {
			}
		}
	}

}
