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
	int mLayoutResourceId;	
	int mDropDownResourceId;
	List<Language> mLanguageList = new ArrayList<Language>();

	public LanguageSpinnerAdapter(Context context,
			List<Language> objects) {
		super(context, R.layout.custom_spinner, objects);
		this.mLayoutResourceId = R.layout.custom_spinner;		
		this.mDropDownResourceId = R.layout.custom_spinner_item;
		this.mContext = context;
		this.mLanguageList = objects;
		
		setDropDownViewResource(R.layout.custom_spinner_item);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(mLayoutResourceId, parent, false);
		}

		Language item = mLanguageList.get(position);

		TextView spinnerTitle = (TextView) convertView
				.findViewById(R.id.spinner_language);
		spinnerTitle.setText(LanguageHelper.getLanguageName(mContext,
				item.getLanguageCode()));
		return convertView;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {		
		
		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(mDropDownResourceId, parent, false);
		}
		
		TextView dropDownItem;
		if(convertView instanceof TextView){
			dropDownItem = (TextView) convertView;
		} else {
			dropDownItem = (TextView) convertView.findViewById(R.id.drop_down_item);
		}
		
		Language item = mLanguageList.get(position);
		
		dropDownItem.setText(LanguageHelper.getLanguageName(mContext,
				item.getLanguageCode()));

		return convertView;
	}

}
