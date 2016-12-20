package com.xi_zz.activitylaunchmode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
	protected static final String KEY_LEVEL = "level";

	protected int level = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		level = getIntent().getIntExtra(KEY_LEVEL, 0);
		TextView textView = (TextView) findViewById(R.id.textView);
		textView.setText("Level: " + level);
	}

	public void launchStandard(View view)
	{
		Intent intent = new Intent(this, StandardActivity.class);
		intent.putExtra(KEY_LEVEL, level + 1);
		startActivity(intent);
	}

	public void launchSingleTop(View view)
	{
		Intent intent = new Intent(this, SingleTopActivity.class);
		intent.putExtra(KEY_LEVEL, level + 1);
		startActivity(intent);
	}

	public void launchSingleTask(View view)
	{
		Intent intent = new Intent(this, SingleTaskActivity.class);
		intent.putExtra(KEY_LEVEL, level + 1);
		startActivity(intent);
	}

	public void launchSingleInstance(View view)
	{
		Intent intent = new Intent(this, SingleInstanceActivity.class);
		intent.putExtra(KEY_LEVEL, level + 1);
		startActivity(intent);
	}
}
