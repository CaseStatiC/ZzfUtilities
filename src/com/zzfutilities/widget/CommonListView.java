package com.zzfutilities.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzfutilities.R;

public class CommonListView {

	// 菜单适配器
	private class MenuAdapter extends ArrayAdapter<String> {

		public MenuAdapter(Context context, int resource) {
			super(context, resource);
			// TODO Auto-generated constructor stub
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View rowView = null;
			// LayoutInflater inflater = mFMmActivity.getLayoutInflater();
			// View rowView = inflater.inflate(
			// R.layout.sliding_menu_listview_layout, null, true);
			// TextView txtTitle = (TextView) rowView
			// .findViewById(R.id.sliding_name);
			//
			// ImageView imageView = (ImageView) rowView
			// .findViewById(R.id.sliding_image);
			return rowView;
		}

	}
}
