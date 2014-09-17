package com.transround.dev.localizationdemo;

import java.text.NumberFormat;
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
	int mLayoutResourceId;

	public LanguageDetailArrayAdapter(Context context, Language language) {
		super(context, R.layout.custom_list_item, getLanguageDetailList(
				context, language));
		this.mLayoutResourceId = R.layout.custom_list_item;
		this.mContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
			convertView = inflater.inflate(mLayoutResourceId, parent, false);
		}

		LanguageDetailListItem item = getItem(position);

		TextView textViewTitle = (TextView) convertView
				.findViewById(R.id.itemTitle);
		textViewTitle.setText(item.getTitle());

		TextView textViewValue = (TextView) convertView
				.findViewById(R.id.itemValue);
		textViewValue.setText(item.getValue());
		return convertView;
	}

	private static List<LanguageDetailListItem> getLanguageDetailList(
			Context context, Language language) {
		List<LanguageDetailListItem> languageDetailListItems = new ArrayList<LanguageDetailListItem>();
		NumberFormat formatter = NumberFormat.getInstance();
		languageDetailListItems.add(new LanguageDetailListItem(context
				.getResources().getString(R.string.label_population), String
				.valueOf(formatter.format(language.getPopulation()))));

		languageDetailListItems
				.add(new LanguageDetailListItem(context.getResources()
						.getString(R.string.label_smartphone_users),
						String.valueOf(formatter.format(language
								.getSmartPhoneUsers()))));

		languageDetailListItems.add(new LanguageDetailListItem(context
				.getResources().getString(R.string.label_english_users), String
				.valueOf(formatter.format(language.getEnglishUsers()))));

		languageDetailListItems.add(new LanguageDetailListItem(context
				.getResources().getString(R.string.label_local_language_users),
				String.valueOf(formatter.format(language
						.getLocalLanguageUsers()))));

		languageDetailListItems.add(new LanguageDetailListItem(context
				.getResources()
				.getString(R.string.label_smartphone_penetration), String
				.valueOf(language.getSmartPhonePenetration() + "%")));

		return languageDetailListItems;
	}

}
