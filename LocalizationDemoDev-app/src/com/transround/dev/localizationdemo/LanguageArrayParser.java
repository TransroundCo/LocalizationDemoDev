package com.transround.dev.localizationdemo;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

public class LanguageArrayParser {

	Context context;

	public LanguageArrayParser(Context context) {
		this.context = context;
	}

	public List<Language> parseCountries(String[] languages,
			String[] languagesPopulation, String[] languagesSmartPhoneUsers,
			String[] languagesEnglishUsers,
			String[] languagesLocalLanguageUsers,
			String[] languagesSmartPhonePenetration) {

		if (languages.length != languagesPopulation.length
				|| languages.length != languagesSmartPhoneUsers.length
				|| languages.length != languagesEnglishUsers.length
				|| languages.length != languagesLocalLanguageUsers.length
				|| languages.length != languagesSmartPhonePenetration.length) {
			String message = context.getResources().getString(
					R.string.DIFFERENT_SOURCE_LENGTH_EXCEPTION);
			throw new IllegalArgumentException(message != null ? message
					: "The length of input arrays are different!");
		}

		List<Language> LanguageList = new ArrayList<Language>();
		for (int i = 0; i < languages.length; i++) {
			Language newLanguage = new Language();
			newLanguage.setName(languages[i]);
			newLanguage.setPopulation(Long.parseLong(languagesPopulation[i]));
			newLanguage.setSmartPhoneUsers(Long
					.parseLong(languagesSmartPhoneUsers[i]));
			newLanguage.setEnglishUsers(Long
					.parseLong(languagesEnglishUsers[i]));
			newLanguage.setLocalLanguageUsers(Long
					.parseLong(languagesLocalLanguageUsers[i]));
			newLanguage.setSmartPhonePenetration(Double
					.parseDouble(languagesSmartPhonePenetration[i]));
			LanguageList.add(newLanguage);
		}

		return LanguageList;
	}

}
