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

	private static final String API_URL = "https://api.github.com";
	private static final RestAdapter REST_ADAPTER = new RestAdapter.Builder().setEndpoint(API_URL).build();
	private static final GitHubService SERVICE = REST_ADAPTER.create(GitHubService.class);

	private TextView textView;
	private EditText editText;
	private ProgressBar progressBar;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.text_username);
		textView = (TextView) findViewById(R.id.text_user_info);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
	}

	public void getUser(View view) {
		progressBar.setVisibility(View.VISIBLE);
		String username = editText.getText().toString();

		SERVICE.getFeed(username, new Callback<User>()
		{
			@Override
			public void success(User user, Response response) {
				textView.setText(user.toString());
				progressBar.setVisibility(View.INVISIBLE);
			}

			@Override
			public void failure(RetrofitError error) {
				textView.setText(error.getMessage());
				progressBar.setVisibility(View.INVISIBLE);
			}
		});
	}
}
