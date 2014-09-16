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

public class LanguageSpinnerAdapter extends ArrayAdapter<Language> {

	Context mContext;
	int layoutResourceId;
	List<Language> countryList = new ArrayList<Language>();

	public LanguageSpinnerAdapter(Context context, int resource,
			List<Language> objects) {
		super(context, resource, objects);
		this.layoutResourceId = resource;
		this.mContext = context;
		this.countryList = objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(layoutResourceId, parent, false);
		}

		Language item = countryList.get(position);

		TextView spinnerTitle = (TextView) convertView
				.findViewById(R.id.spinner_language);
		spinnerTitle.setText(item.getName());
		return convertView;
	}

}
