package com.xi_zz.buildvariant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView displayText = (TextView) findViewById(R.id.display_text);
		displayText.setText(getString(R.string.product_flavor) + " " + getString(R.string.build_type));
	}
}
