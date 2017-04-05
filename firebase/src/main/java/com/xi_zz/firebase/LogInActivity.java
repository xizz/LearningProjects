package com.xi_zz.firebase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogInActivity extends AppCompatActivity
{
	private FirebaseAuth auth;

	private EditText emailEditText;
	private EditText passwordEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);

		emailEditText = (EditText) findViewById(R.id.edit_text_email);
		passwordEditText = (EditText) findViewById(R.id.edit_text_password);

		auth = FirebaseAuth.getInstance();
	}

	public void logIn(View view)
	{
		String email = emailEditText.getText().toString();
		String password = passwordEditText.getText().toString();

		auth.signInWithEmailAndPassword(email, password)
				.addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
				{
					@Override
					public void onComplete(@NonNull Task<AuthResult> task)
					{
						if (task.isSuccessful())
						{
							Toast.makeText(LogInActivity.this, task.getResult().getUser().getEmail() + " logged in successful",
									Toast.LENGTH_SHORT).show();
							finish();
						}
						else
						{
							Toast.makeText(LogInActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
						}

					}
				});
	}

	public void SignUp(View view)
	{
		String email = emailEditText.getText().toString();
		String password = passwordEditText.getText().toString();

		auth.createUserWithEmailAndPassword(email, password)
				.addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
				{
					@Override
					public void onComplete(@NonNull Task<AuthResult> task)
					{
						if (task.isSuccessful())
						{
							Toast.makeText(LogInActivity.this, task.getResult().getUser().getEmail() + " signed up successful",
									Toast.LENGTH_SHORT).show();
							finish();
						}
						else
						{
							Toast.makeText(LogInActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
						}

					}
				});
	}
}
