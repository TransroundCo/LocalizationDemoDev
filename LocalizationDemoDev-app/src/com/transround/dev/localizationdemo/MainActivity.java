package com.transround.dev.localizationdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView countryView;
	TextView populationView;
	TextView englishSpeakersView;
	TextView nativeSpeakersView;
	TextView penetrationView;
	TextView demoInstructionsView;

	Spinner countrySpinner;
	Button shareButton;
	Button sendFeedback;
	ListView languageDetailListView;
	List<Language> countries = new ArrayList<Language>(0);

	LocalizationDemoApplication app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		app = (LocalizationDemoApplication) getApplication();

		LanguageArrayParser countryArrayParser = new LanguageArrayParser(this);
		countries = countryArrayParser.parseCountries(
				getResources().getStringArray(R.array.languages_array),
				getResources().getStringArray(R.array.population_array),
				getResources().getStringArray(R.array.smartphone_users_array),
				getResources().getStringArray(R.array.english_users_array),
				getResources().getStringArray(
						R.array.local_language_users_array),
				getResources().getStringArray(
						R.array.smartphone_penetration_array));

		Log.d("LocalizationDemo", "Country List size: " + countries.size());

		LanguageSpinnerAdapter countrySpinnerAdapter = new LanguageSpinnerAdapter(
				this, R.layout.custom_spinner, countries);

		countrySpinnerAdapter
				.setDropDownViewResource(R.layout.custom_spinner_item);

		countrySpinner = (Spinner) findViewById(R.id.spinner_language);
		countrySpinner.setAdapter(countrySpinnerAdapter);
		countrySpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				refreshDataByArrayPosition(pos);
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

		languageDetailListView = (ListView) findViewById(R.id.list_language_detail);

		shareButton = (Button) findViewById(R.id.button_share);
		shareButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String message = buildCountryInfoToLocalizedString(countries
						.get(countrySpinner.getSelectedItemPosition()));
				Log.d("LocalizationDemo", "Send Country: \n" + message);
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT, message);
				sendIntent.setType("text/plain");
				startActivity(Intent.createChooser(sendIntent, getResources()
						.getText(R.string.send_to)));

			}
		});

		demoInstructionsView = (TextView) findViewById(R.id.label_help_link);
		String demoInstructionsString = getResources().getString(
				R.string.label_demo_instructions);
		String transroundHelpLink = getResources().getString(
				R.string.transround_help_link);
		String demoInstructionsLink = "<a href=\"" + transroundHelpLink + "\">"
				+ demoInstructionsString + "</a>";
		demoInstructionsView.setText(Html.fromHtml(demoInstructionsLink));

		demoInstructionsView
				.setMovementMethod(LinkMovementMethod.getInstance());

		sendFeedback = (Button) findViewById(R.id.button_feedback);
		sendFeedback.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String transroundInfoEmail = getResources().getString(
						R.string.transround_info_email);
				String feedbackSubject = getResources().getString(
						R.string.feedback_email_subject);
				String chooseEmailClientHeader = getResources().getString(
						R.string.header_choose_email_client);

				Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
						"mailto", transroundInfoEmail, null));
				intent.putExtra(Intent.EXTRA_SUBJECT, feedbackSubject);
				startActivity(Intent.createChooser(intent,
						chooseEmailClientHeader));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_help:
			openHelp();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void openHelp() {
		Intent intent = new Intent(this, HelpActivity.class);
		startActivity(intent);
	}

	private void refreshDataByArrayPosition(int pos) {
		Language country = countries.get(pos);
		LanguageDetailArrayAdapter countryDetailArrayAdapter = new LanguageDetailArrayAdapter(
				this, R.layout.custom_list_item,
				LanguageDetailListFactory.getCountryDetailList(this, country));

		languageDetailListView.setAdapter(countryDetailArrayAdapter);
	}

	private String buildCountryInfoToLocalizedString(Language country) {
		StringBuffer sb = new StringBuffer();
		sb.append(getResources().getString(R.string.label_language));
		sb.append("      ");
		sb.append(country.getName());
		sb.append("\n");
		sb.append(getResources().getString(R.string.label_population));
		sb.append("      ");
		sb.append(country.getPopulation());
		sb.append("\n");
		sb.append(getResources().getString(R.string.label_english_users));
		sb.append("      ");
		sb.append(country.getEnglishUsers());
		sb.append("\n");
		sb.append(getResources().getString(R.string.label_local_language_users));
		sb.append("      ");
		sb.append(country.getLocalLanguageUsers());
		sb.append("\n");
		sb.append(getResources().getString(
				R.string.label_smartphone_penetration));
		sb.append("      ");
		sb.append(country.getSmartPhonePenetration());
		sb.append("\n");
		sb.append(getResources().getString(R.string.transround_link));
		return sb.toString();
	}

}
