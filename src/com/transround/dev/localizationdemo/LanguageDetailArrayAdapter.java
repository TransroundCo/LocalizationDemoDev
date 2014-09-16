package com.transround.dev.localizationdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class LanguageDetailArrayAdapter extends
		ArrayAdapter<LanguageDetailListItem> {

	Context mContext;
	int layoutResourceId;
	List<LanguageDetailListItem> countryDetailList = new ArrayList<LanguageDetailListItem>();

	public LanguageDetailArrayAdapter(Context context, int layoutResourceId,
			List<LanguageDetailListItem> objects) {
		super(context, layoutResourceId, objects);

		this.layoutResourceId = layoutResourceId;
		this.mContext = context;
		this.countryDetailList = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(layoutResourceId, parent, false);
		}

		LanguageDetailListItem item = countryDetailList.get(position);

		TextView textViewTitle = (TextView) convertView
				.findViewById(R.id.itemTitle);
		textViewTitle.setText(item.getTitle());

		TextView textViewValue = (TextView) convertView
				.findViewById(R.id.itemValue);
		textViewValue.setText(item.getValue());
		return convertView;
	}

}
