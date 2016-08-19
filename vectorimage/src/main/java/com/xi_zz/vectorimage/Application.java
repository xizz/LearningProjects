package com.xi_zz.vectorimage;

import android.support.v7.app.AppCompatDelegate;

public class Application extends android.app.Application {
	@Override
	public void onCreate() {
		super.onCreate();
		// vectorDrawables.useSupportLibrary = true
		AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
	}
}
