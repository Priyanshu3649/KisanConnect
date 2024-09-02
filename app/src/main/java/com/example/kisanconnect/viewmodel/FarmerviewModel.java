package com.example.kisanconnect.viewmodel;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.yourappname.data.FarmerRepository;
import com.yourappname.models.Farmer;

import java.util.List;

public class FarmerViewModel extends AndroidViewModel {
    private FarmerRepository repository;
    private LiveData<List<Farmer>> allFarmers;

    public FarmerViewModel(Application application) {
        super(application);
        repository = new FarmerRepository(application);
        allFarmers = repository.getAllFarmers();
    }

    public void insert(Farmer farmer) {
        repository.insert(farmer);
    }

    public LiveData<List<Farmer>> getAllFarmers() {
        return allFarmers;
    }
}