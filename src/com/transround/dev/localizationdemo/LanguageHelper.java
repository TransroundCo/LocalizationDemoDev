package com.transround.dev.localizationdemo;

import android.content.Context;
import android.util.Log;

public class LanguageHelper {
	public static final String TAG = "LanguageHelper";
	private static final String sLanguageNamePrefix = "lang_display_name_";

	public static CharSequence getLanguageName(Context context,
			String languageCode) {
		Log.d(TAG, "get language res id for: " + languageCode);

		final int languageDisplayNameId = context.getResources().getIdentifier(
				sLanguageNamePrefix + languageCode, "string",
				context.getPackageName());
		Log.d(TAG, "res id: " + languageDisplayNameId);

		if (languageDisplayNameId > 0) {
			return context.getResources().getString(languageDisplayNameId);
		} else {
			return "UnknownLanguage";
		}
	}

}
