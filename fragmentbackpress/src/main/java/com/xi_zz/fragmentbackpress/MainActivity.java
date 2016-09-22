package com.xi_zz.fragmentbackpress;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setSupportActionBar((Toolbar) findViewById(R.id.my_toolbar));
		getSupportActionBar().setTitle(R.string.app_name);
	}

	public void launchSecondActivity(View view) {
		Intent intent = new Intent(this, SecondActivity.class);
		startActivity(intent);
	}
}
