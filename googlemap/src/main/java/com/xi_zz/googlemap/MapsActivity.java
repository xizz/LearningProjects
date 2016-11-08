package com.xi_zz.googlemap;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback
{
	private static MapView sMapView;

	private ViewGroup mMapContainerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);

		mMapContainerLayout = (ViewGroup) findViewById(R.id.mapContainer);
		if (sMapView == null)
		{
			MapsInitializer.initialize(getApplicationContext());
			sMapView = new MapView(getApplicationContext());
			sMapView.getMapAsync(this);
			sMapView.onCreate(null);
		}
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		sMapView.onStart();
		sMapView.onResume();
		mMapContainerLayout.addView(sMapView);
	}

	@Override
	protected void onPause()
	{
		super.onPause();
		mMapContainerLayout.removeAllViews();
		sMapView.onPause();
		sMapView.onStop();
	}

	/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker near Sydney, Australia.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 */
	@Override
	public void onMapReady(GoogleMap googleMap)
	{
		GoogleMap map = googleMap;

		// Add a marker in Sydney and move the camera
		LatLng sydney = new LatLng(-34, 151);
		map.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
		map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
	}
}
