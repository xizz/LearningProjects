package com.xi_zz.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService
{
	@GET("/users/{user}")
	Call<User> getFeed(@Path("user") String user);
//	void getFeed(@Path("user") String user, Callback<User> response);
}
