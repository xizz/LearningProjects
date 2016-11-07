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
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

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

		loginButton.setReadPermissions("public_profile", "email", "user_birthday", "user_friends");
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
		GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback()
		{
			@Override
			public void onCompleted(JSONObject object, GraphResponse response)
			{
				StringBuilder text = new StringBuilder();
				try
				{
					text.append(object.getString("name") + "\n");
					text.append(object.getString("id") + "\n");
					text.append(object.getString("email") + "\n");
					text.append(object.getString("gender") + "\n");
					text.append(object.getString("birthday") + "\n");
					text.append(profile.getLinkUri() + "\n");
				}
				catch (JSONException e)
				{
					e.printStackTrace();
				}
				displayText.setText(text);

			}
		});
		Bundle args = new Bundle();
		args.putString("fields", "id,name,email,gender,birthday");
		request.setParameters(args);
		request.executeAsync();


	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		callbackManager.onActivityResult(requestCode, resultCode, data);
	}
}
