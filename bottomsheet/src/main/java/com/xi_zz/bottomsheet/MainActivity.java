package com.xi_zz.bottomsheet;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

	private BottomSheetBehavior bottomSheetBehavior;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		View bottomSheet = findViewById(R.id.bottom_sheet);

		bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
		bottomSheetBehavior.setPeekHeight(0);

	}

	public void open(View view)
	{
		bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
	}

	public void close(View view)
	{
		bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
	}
}
