package com.xi_zz.vectorimage;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public class Appication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}
}
