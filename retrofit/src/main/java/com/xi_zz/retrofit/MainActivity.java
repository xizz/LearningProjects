package com.xi_zz.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

	private String API_URL = "https://api.github.com";

	private TextView mTextView;
	private EditText mEditText;
	private ProgressBar mProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mEditText = (EditText) findViewById(R.id.text_username);
		mTextView = (TextView) findViewById(R.id.text_user_info);
		mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
	}

	public void getUser(View view) {
		String username = mEditText.getText().toString();
		mProgressBar.setVisibility(View.VISIBLE);

		RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API_URL).build();
		GitHubApi gitHubApi = restAdapter.create(GitHubApi.class);
		gitHubApi.getFeed(username, new Callback<User>() {
			@Override
			public void success(User user, Response response) {
				mTextView.setText("Github Name :" + user.getName() + "\nWebsite :" + user.getBlog()
						+ "\nCompany Name :" + user.getCompany());

				mProgressBar.setVisibility(View.INVISIBLE);
			}

			@Override
			public void failure(RetrofitError error) {
				mTextView.setText(error.getMessage());
				mProgressBar.setVisibility(View.INVISIBLE);
			}
		});
	}
}
