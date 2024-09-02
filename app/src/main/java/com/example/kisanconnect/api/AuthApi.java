package com.example.kisanconnect.api;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AuthApi {
    @POST("login")
    Call<LoginResponse> login(@Query("username") String username, @Query("password") String password);
}
