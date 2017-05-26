package com.xi_zz.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

	private static final String API_URL = "https://api.github.com";
	private static final Retrofit RETROFIT = new Retrofit.Builder().baseUrl(API_URL).addConverterFactory(GsonConverterFactory.create()).build();
	private static final GitHubService SERVICE = RETROFIT.create(GitHubService.class);

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

		Call<User> call = SERVICE.getFeed(username);

		call.enqueue(new Callback<User>()
		{
			@Override
			public void onResponse(Call<User> call, Response<User> response)
			{
				textView.setText(response.body().toString());
				progressBar.setVisibility(View.GONE);
			}

			@Override
			public void onFailure(Call<User> call, Throwable t)
			{
				textView.setText("Error");
				progressBar.setVisibility(View.GONE);
			}
		});
	}
}
