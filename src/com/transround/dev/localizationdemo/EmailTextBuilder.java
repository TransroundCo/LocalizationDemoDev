package com.transround.dev.localizationdemo;

import android.content.Context;

public class EmailTextBuilder {
	public static String buildEmailText(Context context, Language language){
		StringBuffer sb = new StringBuffer();
		sb.append(context.getResources().getString(R.string.label_language));
		sb.append("      ");
		sb.append(LanguageHelper.getLanguageName(context,
				language.getLanguageCode()));
		sb.append("\n");
		sb.append(context.getResources().getString(R.string.label_population));
		sb.append("      ");
		sb.append(language.getPopulation());
		sb.append("\n");
		sb.append(context.getResources().getString(R.string.label_english_users));
		sb.append("      ");
		sb.append(language.getEnglishUsers());
		sb.append("\n");
		sb.append(context.getResources().getString(R.string.label_local_language_users));
		sb.append("      ");
		sb.append(language.getLocalLanguageUsers());
		sb.append("\n");
		sb.append(context.getResources().getString(
				R.string.label_smartphone_penetration));
		sb.append("      ");
		sb.append(language.getSmartPhonePenetration());
		sb.append("\n");
		sb.append(context.getResources().getString(R.string.transround_link));
		return sb.toString();
	}
}
