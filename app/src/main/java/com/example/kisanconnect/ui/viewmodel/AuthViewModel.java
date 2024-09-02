package com.example.kisanconnect.ui.viewmodel;

import android.util.Log;
import androidx.lifecycle.ViewModel;
import com.example.kisanconnect.api.AuthApi;
import com.example.kisanconnect.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthViewModel extends ViewModel {
    private final AuthApi authApi;

    public AuthViewModel() {
        authApi = RetrofitClient.getRetrofitInstance().create(AuthApi.class);
    }

    public void login(String username, String password, final LoginCallback callback) {
        Call<LoginResponse> call = authApi.login(username, password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Handle successful login
                    callback.onSuccess();
                } else {
                    callback.onFailure("Login failed");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("AuthViewModel", "Login error", t);
                callback.onFailure("Login error");
            }
        });
    }

    public interface LoginCallback {
        void onSuccess();
        void onFailure(String message);
    }
}
