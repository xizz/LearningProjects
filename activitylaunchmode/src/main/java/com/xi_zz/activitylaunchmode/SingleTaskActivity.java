package com.xi_zz.activitylaunchmode;

import android.os.Bundle;

// It only exist in application task, not other tasks.
// It will kill anything on top of it.
public class SingleTaskActivity extends MainActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle("SingleTaskActivity");
	}
}
