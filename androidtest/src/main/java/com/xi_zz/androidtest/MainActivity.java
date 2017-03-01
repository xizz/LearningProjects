package com.xi_zz.androidtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
	private TextView mDisplayText;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mDisplayText = (TextView) findViewById(R.id.display_text);
	}

	public void showMessage(View view)
	{
		mDisplayText.setText(R.string.hello_world);
	}
}
