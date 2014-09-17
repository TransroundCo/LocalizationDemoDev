package com.transround.dev.localizationdemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

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
	public static final String TAG = "MainActivity";
	TextView mLanguageTextView;
	TextView mDemoInstructionsTextView;

	Spinner mLanguageSpinner;
	Button mShareButton;
	Button mSendFeedback;
	ListView mLanguageDetailListView;
	
	List<Language> mLanguageList = new ArrayList<Language>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initLanguageList();

		initLanguageSpinner();

		initLanguageDetailList();

		initShareButton();

		initDemoInstructionsLabel();

		initFeedbackButton();
	}

	private void initFeedbackButton() {
		mSendFeedback = (Button) findViewById(R.id.button_feedback);
		mSendFeedback.setOnClickListener(new OnClickListener() {
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

	private void initDemoInstructionsLabel() {
		mDemoInstructionsTextView = (TextView) findViewById(R.id.label_help_link);
		String demoInstructionsString = getResources().getString(
				R.string.label_demo_instructions);
		String transroundHelpLink = getResources().getString(
				R.string.transround_help_link);
		String demoInstructionsLink = "<a href=\"" + transroundHelpLink + "\">"
				+ demoInstructionsString + "</a>";
		mDemoInstructionsTextView.setText(Html.fromHtml(demoInstructionsLink));

		mDemoInstructionsTextView
				.setMovementMethod(LinkMovementMethod.getInstance());
	}

	private void initShareButton() {
		mShareButton = (Button) findViewById(R.id.button_share);
		mShareButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Language selectedLanguage = mLanguageList
						.get(mLanguageSpinner.getSelectedItemPosition());
				
				String message = EmailTextBuilder.buildEmailText(MainActivity.this, selectedLanguage);
				
				Log.d("LocalizationDemo", "Send Country: \n" + message);
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT, message);
				sendIntent.setType("text/plain");
				startActivity(Intent.createChooser(sendIntent, getResources()
						.getText(R.string.send_to)));

			}
		});
	}

	private void initLanguageDetailList() {
		mLanguageDetailListView = (ListView) findViewById(R.id.list_language_detail);
	}

	private void initLanguageSpinner() {
		LanguageSpinnerAdapter languageSpinnerAdapter = new LanguageSpinnerAdapter(
				this, mLanguageList);

		mLanguageSpinner = (Spinner) findViewById(R.id.spinner_language);
		mLanguageSpinner.setAdapter(languageSpinnerAdapter);
		mLanguageSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int pos, long id) {
				setLanguageOnDisplayByPosition(pos);
			}

			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}

	private void initLanguageList() {
		try {
			mLanguageList = LanguageJsonParser
					.parseLanguageJsonToList(getResources().openRawResource(
							getResources().getIdentifier("raw/languages",
									"raw", getPackageName())));
		} catch (IOException e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage());
		} catch (JSONException e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage());
		}
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
			startHelpActivity();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	private void startHelpActivity() {
		Intent intent = new Intent(this, HelpActivity.class);
		startActivity(intent);
	}

	private void setLanguageOnDisplayByPosition(int pos) {
		Language language = mLanguageList.get(pos);
		LanguageDetailArrayAdapter languageDetailArrayAdapter = new LanguageDetailArrayAdapter(
				this, language);

		mLanguageDetailListView.setAdapter(languageDetailArrayAdapter);
	}
	
}
