package com.transround.dev.localizationdemo;

import java.lang.reflect.Field;

import android.app.Application;
import android.view.ViewConfiguration;

public class LocalizationDemoApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// hack to force soft menu key even if device has a hardware menu key
		try {
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			if (menuKeyField != null) {
				menuKeyField.setAccessible(true);
				menuKeyField.setBoolean(config, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
