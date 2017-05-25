package com.xi_zz.progressbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ContentFragment extends MainFragment
{
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
	{
		ViewGroup view = (ViewGroup) super.onCreateView(inflater, container, savedInstanceState);
		view.addView(inflater.inflate(R.layout.fragment_content, container, false));
		return view;
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		showProgressSpinner();
//		hideProgressSpinner();
	}
}
