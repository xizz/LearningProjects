package com.xi_zz.intentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity
{
	private TextView textView;
	private DownloadReceiver downloadReceiver = new DownloadReceiver();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = (TextView) findViewById(R.id.display_text);

		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(FileService.TRANSACTION_TEXT);
		registerReceiver(downloadReceiver, intentFilter);

		startFileService();
	}

	@Override
	protected void onDestroy()
	{
		unregisterReceiver(downloadReceiver);
		super.onDestroy();
	}

	void startFileService()
	{
		Intent intent = new Intent(this, FileService.class);
		intent.putExtra(Constants.URL, "http://www.textfiles.com/adventure/221baker.txt");
		startService(intent);
	}


	void showFileContent()
	{
		StringBuilder stringBuilder = new StringBuilder();
		try
		{
			FileInputStream fis = this.openFileInput(Constants.FILENAME);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

			BufferedReader bufferedReader = new BufferedReader(isr);
			String line;
			while ((line = bufferedReader.readLine()) != null)
			{
				stringBuilder.append(line).append("\n");
			}
			textView.setText(stringBuilder.toString());
		}
		catch (FileNotFoundException | UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private class DownloadReceiver extends BroadcastReceiver
	{
		@Override
		public void onReceive(Context context, Intent intent)
		{
			Log.e("FileService", "Service broadcasted");
			showFileContent();
		}
	}
}
