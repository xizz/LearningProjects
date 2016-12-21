package com.xi_zz.activitylaunchmode;

import android.os.Bundle;


// It has its own task and its own task only contains it.
// It has a one to one relationship with its task.
// A new <activity, task> will be created when first launch.
// The existing <activity, task> will be used otherwise.
// Standard, SingleTop, SingleTask activities will be launch at application task.
// Application task will be created if it doesn't.
public class SingleInstanceActivity extends MainActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle("SingleInstanceActivity");
	}
}
