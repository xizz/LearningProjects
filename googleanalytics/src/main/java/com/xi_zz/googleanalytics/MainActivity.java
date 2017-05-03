package com.xi_zz.googleanalytics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity
{
	Tracker tracker;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		AnalyticsApplication application = (AnalyticsApplication) getApplication();
		tracker = application.getDefaultTracker();


		tracker.setScreenName("Image~" + MainActivity.class.getSimpleName());
		tracker.send(new HitBuilders.ScreenViewBuilder().build());
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		tracker.send(new HitBuilders.EventBuilder().setCategory("Action").setAction("App Resume").build());
	}
}
