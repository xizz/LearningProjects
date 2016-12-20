package com.xi_zz.activitylaunchmode;

import android.os.Bundle;

public class StandardActivity extends MainActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle("StandardActivity");
	}
}
