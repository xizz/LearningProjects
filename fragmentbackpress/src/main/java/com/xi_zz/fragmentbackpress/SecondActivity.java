package com.xi_zz.fragmentbackpress;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class SecondActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
		setSupportActionBar(toolbar);

		getSupportActionBar().setTitle(R.string.app_name);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//		toolbar.setTitle(R.string.app_name);
//		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(final View view) {
//				onBackPressed();
//			}
//		});

		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.container, new FirstFragment())
				.commit();
	}

	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		switch (item.getItemId()) {
			case android.R.id.home:
				onBackPressed();
			default:
				return super.onOptionsItemSelected(item);
		}
	}
}
