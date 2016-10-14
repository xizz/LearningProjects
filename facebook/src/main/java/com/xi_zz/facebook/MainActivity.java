package com.xi_zz.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity
{

	private TextView displayText;
	private LoginButton loginButton;
	private LoginManager loginManager;
	private CallbackManager callbackManager;
	private AccessToken accessToken;
	private Profile profile;
	private AccessTokenTracker accessTokenTracker;
	private ProfileTracker profileTracker;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		displayText = (TextView) findViewById(R.id.display_text);
		loginButton = (LoginButton) findViewById(R.id.login_button);

		loginManager = LoginManager.getInstance();

		callbackManager = CallbackManager.Factory.create();

		accessToken = AccessToken.getCurrentAccessToken();
		profile = Profile.getCurrentProfile();

		loginButton.setReadPermissions("email");
		loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
		{
			@Override
			public void onSuccess(LoginResult loginResult)
			{
				accessToken = loginResult.getAccessToken();
			}

			@Override
			public void onCancel() {}

			@Override
			public void onError(FacebookException error)
			{
				displayText.setText(error.getMessage());
			}
		});
	}

	@Override
	protected void onResume()
	{
		super.onResume();
		setDisplay();
	}

	private void setDisplay()
	{
		if (accessToken == null || profile == null)
		{
			displayText.setText("You are not logged in");
		}
		else
		{
			StringBuilder text = new StringBuilder();
			text.append(accessToken.getApplicationId() + "\n");
			text.append(accessToken.getUserId() + "\n");
			text.append(accessToken.getToken() + "\n");
			text.append(profile.getName() + "\n");
			displayText.setText(text);
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		callbackManager.onActivityResult(requestCode, resultCode, data);
	}
}
