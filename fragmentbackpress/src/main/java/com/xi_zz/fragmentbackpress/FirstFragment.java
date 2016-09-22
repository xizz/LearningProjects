package com.xi_zz.fragmentbackpress;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {

	@Override
	public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable final Bundle savedInstanceState) {
		return LayoutInflater.from(getContext()).inflate(R.layout.fragment_first, container, false);
	}

	@Override
	public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
		Button button = (Button) getView().findViewById(R.id.launchFragment2Btn);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(final View view) {
				getFragmentManager()
						.beginTransaction()
						.replace(R.id.container, new SecondFragment())
						.addToBackStack(null)
						.commit();
			}
		});
	}
}
