package com.transround.dev.localizationdemo;

import com.transround.plugin.aspect.TransroundAspect.DontTouchThis;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

@DontTouchThis
public class HelpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WebView webview = new WebView(this);
		setContentView(webview);
		webview.loadUrl(getResources().getString(R.string.transround_help_link));

	}

}
