package com.xi_zz.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity
{
	private static final GitHubService SERVICE;

	static
	{
		HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
		// set your desired log level
		logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);

		OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
		httpClientBuilder
				.addInterceptor(new Interceptor()
				{
					@Override
					public okhttp3.Response intercept(Chain chain) throws IOException
					{
						Request.Builder requestBuilder = chain.request().newBuilder()
								.header("Authorization", "Basic [your GitHub personal access token]");
						return chain.proceed(requestBuilder.build());
					}
				})
				.addInterceptor(logging);
		Retrofit retrofit = new Retrofit
				.Builder()
				.baseUrl("https://api.github.com")
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClientBuilder.build())
				.build();

		SERVICE = retrofit.create(GitHubService.class);
	}

	private EditText usernameText;
	private TextView resultText;
	private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		usernameText = (EditText) findViewById(R.id.text_username);
		resultText = (TextView) findViewById(R.id.text_user_info);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
	}

	public void getUser(View view)
	{
		progressBar.setVisibility(View.VISIBLE);
		String queryName = usernameText.getText().toString();

		Call<User> call = SERVICE.getUserInfo(queryName);

		call.enqueue(new Callback<User>()
		{
			@Override
			public void onResponse(Call<User> call, Response<User> response)
			{
				if (response.body() != null)
					resultText.setText(response.body().toString());
				else
				{
					try
					{
						resultText.setText(response.code() + "\n" + response.errorBody().string() + "\n" + response.message());
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
				progressBar.setVisibility(View.GONE);
			}

			@Override
			public void onFailure(Call<User> call, Throwable t)
			{
				resultText.setText("Error");
				progressBar.setVisibility(View.GONE);
			}
		});
	}
}
