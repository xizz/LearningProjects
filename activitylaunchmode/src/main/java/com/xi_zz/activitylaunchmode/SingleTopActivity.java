package com.xi_zz.activitylaunchmode;

import android.os.Bundle;

// Always start in the same task. It can be task of other application.
// It won't start if there is already one on top of the current task stack.
public class SingleTopActivity extends MainActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getSupportActionBar().setTitle("SingleTopActivity");
	}
}
