package com.xi_zz.intentservice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FileService extends IntentService
{

	public static final String TRANSACTION_TEXT = "com.xi_zz.intentservice";


	public FileService()
	{
		super("FileService");
	}

	@Override
	protected void onHandleIntent(Intent intent)
	{

		Log.e("FileService", "started");
		String passedUrl = intent.getStringExtra(Constants.URL);
		downloadFile(passedUrl);
		Log.e("FileService", "stopped");

		Intent i = new Intent(TRANSACTION_TEXT);
		sendBroadcast(i); // alert
	}

	public void downloadFile(String theUrl)
	{
		try
		{
			FileOutputStream outputStream = openFileOutput(Constants.FILENAME, Context.MODE_PRIVATE);
			URL fileURL = new URL(theUrl);

			HttpURLConnection urlConnection = (HttpURLConnection) fileURL.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoOutput(true);
			urlConnection.connect();
			InputStream inputStream = urlConnection.getInputStream();
			byte[] buffer = new byte[1024];
			int bufferlength = 0;

			while ((bufferlength = inputStream.read(buffer)) > 0)
			{
				outputStream.write(buffer, 0, bufferlength);
			}
			outputStream.close();

		}
		catch (FileNotFoundException | MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}


}
