package com.xi_zz.bottomnavigation;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		BottomNavigationView view = (BottomNavigationView) findViewById(R.id.bottom_navigation);
		Util.removeShiftMode(view);
	}
}
