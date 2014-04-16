package com.zzfutilities.widget;

import android.widget.EditText;

public class EidtViewEnd {
	public void setCursorEnd() {
		EditText et = null;
		et.setSelection(et.getText().length());
	}

}
