package com.example.kisanconnect.repository;

import com.example.kisanconnect.api.MarketApi;
import com.example.kisanconnect.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketRepository {
    private final MarketApi marketApi;

    public MarketRepository() {
        marketApi = RetrofitClient.getRetrofitInstance().create(MarketApi.class);
    }

    public void getAllMarkets(final MarketCallback callback) {
        Call<List<Market>> call = marketApi.getAllMarkets();
        call.enqueue(new Callback<List<Market>>() {
            @Override
            public void onResponse(Call<List<Market>> call, Response<List<Market>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onFailure("Failed to retrieve markets");
                }
            }

            @Override
            public void onFailure(Call<List<Market>> call, Throwable t) {
                callback.onFailure("Error retrieving markets");
            }
        });
    }

    public interface MarketCallback {
        void onSuccess(List<Market> markets);
        void onFailure(String message);
    }
}
