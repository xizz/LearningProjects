package com.xi_zz.activitylaunchmode;

import android.os.Bundle;

public class SingleTopActivity extends MainActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle("SingleTopActivity");
	}
}
