package com.example.kisanconnect.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.yourappname.models.Market;
import com.yourappname.data.MarketRepository;
import java.util.List;

public class MarketViewModel extends ViewModel {

    private final MarketRepository marketRepository;
    private final MutableLiveData<List<Market>> markets = new MutableLiveData<>();

    public MarketViewModel() {
        marketRepository = new MarketRepository();
        loadMarkets();
    }

    public LiveData<List<Market>> getMarkets() {
        return markets;
    }

    private void loadMarkets() {
        // Load markets from the repository
        List<Market> marketList = marketRepository.getAllMarkets();
        markets.setValue(marketList);
    }
}
