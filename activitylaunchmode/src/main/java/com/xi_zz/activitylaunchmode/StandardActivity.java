package com.xi_zz.activitylaunchmode;

import android.os.Bundle;

// Always start in the same task. It can be task of other application.
public class StandardActivity extends MainActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle("StandardActivity");
	}
}
