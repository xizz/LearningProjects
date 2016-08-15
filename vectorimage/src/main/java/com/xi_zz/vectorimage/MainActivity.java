package com.xi_zz.vectorimage;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ImageView imageView = (ImageView) findViewById(R.id.imageView);

		Drawable drawable;
		VectorDrawable vectorDrawable;
		VectorDrawableCompat vectorDrawableCompat;
		BitmapDrawable bitmapDrawable;

		drawable = ContextCompat.getDrawable(this, R.drawable.call);
		imageView.setImageDrawable(drawable);

		// vectorDrawables.useSupportLibrary = true
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			vectorDrawable = (VectorDrawable) drawable;
		} else {
			vectorDrawableCompat = (VectorDrawableCompat) drawable;
		}

		// vectorDrawables.useSupportLibrary = false
//		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//			vectorDrawable = (VectorDrawable) drawable;
//		} else {
//			bitmapDrawable = (BitmapDrawable) drawable;
//		}
	}
}
