package com.example.kisanconnect.api;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MarketApi {
    @GET("markets")
    Call<List<Market>> getAllMarkets();
}
