package com.transround.dev.localizationdemo;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class LanguageDetailListFactory {
	static final String sIndentString = "    ";

	public static List<LanguageDetailListItem> getCountryDetailList(
			Context context, Language country) {
		List<LanguageDetailListItem> countryDetailListItems = new ArrayList<LanguageDetailListItem>();
		NumberFormat formatter = NumberFormat.getInstance();
		countryDetailListItems.add(new LanguageDetailListItem(context
				.getResources().getString(R.string.label_population), String
				.valueOf(formatter.format(country.getPopulation()))));

		countryDetailListItems
				.add(new LanguageDetailListItem(context.getResources()
						.getString(R.string.label_smartphone_users),
						String.valueOf(formatter.format(country
								.getSmartPhoneUsers()))));

		countryDetailListItems.add(new LanguageDetailListItem(context
				.getResources().getString(R.string.label_english_users), String
				.valueOf(formatter.format(country.getEnglishUsers()))));

		countryDetailListItems
				.add(new LanguageDetailListItem(context.getResources()
						.getString(R.string.label_local_language_users), String
						.valueOf(formatter.format(country
								.getLocalLanguageUsers()))));

		countryDetailListItems.add(new LanguageDetailListItem(context
				.getResources()
				.getString(R.string.label_smartphone_penetration), String
				.valueOf(country.getSmartPhonePenetration() + "%")));

		return countryDetailListItems;
	}
}
