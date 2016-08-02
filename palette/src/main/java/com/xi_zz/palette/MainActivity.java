package com.xi_zz.palette;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private TextView vibrantText;
	private TextView vibrantDarkText;
	private TextView vibrantLightText;
	private TextView mutedText;
	private TextView mutedDarkText;
	private TextView mutedLightText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		vibrantText = (TextView) findViewById(R.id.vibrant);
		vibrantDarkText = (TextView) findViewById(R.id.vibrant_dark);
		vibrantLightText = (TextView) findViewById(R.id.vibrant_light);
		mutedText = (TextView) findViewById(R.id.muted);
		mutedDarkText = (TextView) findViewById(R.id.muted_dark);
		mutedLightText = (TextView) findViewById(R.id.muted_light);

		createPalette();
	}

	public void createPalette() {
		Palette.PaletteAsyncListener paletteAsyncListener = new Palette.PaletteAsyncListener() {
			@Override
			public void onGenerated(Palette palette) {
				Toast.makeText(MainActivity.this, "Palette Generated", Toast.LENGTH_SHORT).show();
				int defaultColor = 0x000000;
				int vibrant = palette.getVibrantColor(defaultColor);
				int vibrantDark = palette.getDarkVibrantColor(defaultColor);
				int vibrantLight = palette.getLightVibrantColor(defaultColor);
				int muted = palette.getMutedColor(defaultColor);
				int mutedDark = palette.getDarkMutedColor(defaultColor);
				int mutedLight = palette.getLightMutedColor(defaultColor);
				vibrantText.setBackgroundColor(vibrant);
				vibrantText.setText("Pixel Count: " + palette.getVibrantSwatch().getPopulation());
				vibrantDarkText.setBackgroundColor(vibrantDark);
				vibrantDarkText.setText("Pixel Count: " + palette.getDarkVibrantSwatch().getPopulation());
				vibrantLightText.setBackgroundColor(vibrantLight);
				vibrantLightText.setText("Pixel Count: " + palette.getLightVibrantSwatch().getPopulation());
				mutedText.setBackgroundColor(muted);
				mutedText.setText("Pixel Count: " + palette.getMutedSwatch().getPopulation());
				mutedDarkText.setBackgroundColor(mutedDark);
				mutedDarkText.setText("Pixel Count: " + palette.getDarkMutedSwatch().getPopulation());
				mutedLightText.setBackgroundColor(mutedLight);
				mutedLightText.setText("Pixel Count: " + palette.getLightMutedSwatch().getPopulation());

			}
		};

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sample);
		if (bitmap != null && !bitmap.isRecycled())
			Palette.from(bitmap).generate(paletteAsyncListener);
	}
}
