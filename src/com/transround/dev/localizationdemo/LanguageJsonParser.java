package com.transround.dev.localizationdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LanguageJsonParser {

	public static List<Language> parseLanguageJsonToList(InputStream jsonStream) throws IOException, JSONException {
		List<Language> languageResultList = new ArrayList<Language>();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				jsonStream, "UTF-8"), 8);
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		String jsonString = sb.toString();

		JSONObject jsonObject = new JSONObject(jsonString);
		
		JSONArray languages = jsonObject.getJSONArray("languages");		
		for(int i = 0; i < languages.length(); i++){
			JSONObject jsonLanguageElement = languages.getJSONObject(i);
			Language newLanguage = new Language();
			newLanguage.setLanguageCode(jsonLanguageElement.getString("languageCode"));
			newLanguage.setPopulation(jsonLanguageElement.getLong("population"));
			newLanguage.setSmartPhoneUsers(jsonLanguageElement.getLong("smartPhoneUsers"));
			newLanguage.setSmartPhonePenetration(jsonLanguageElement.getDouble("smartPhonePenetration"));
			newLanguage.setEnglishUsers(jsonLanguageElement.getLong("englishUsers"));
			newLanguage.setLocalLanguageUsers(jsonLanguageElement.getLong("localLanguageUsers"));
			languageResultList.add(newLanguage);
		}	
		return languageResultList;
	}

}
