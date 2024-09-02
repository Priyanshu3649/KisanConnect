package com.example.kisanconnect.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.yourappname.models.Farmer;

import java.util.List;

public class FarmerRepository {
    private FarmerDao farmerDao;
    private LiveData<List<Farmer>> allFarmers;

    public FarmerRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        farmerDao = db.farmerDao();
        allFarmers = farmerDao.getAllFarmers();
    }

    public void insert(Farmer farmer) {
        new InsertAsyncTask(farmerDao).execute(farmer);
    }

    public LiveData<List<Farmer>> getAllFarmers() {
        return allFarmers;
    }

    private static class InsertAsyncTask extends AsyncTask<Farmer, Void, Void> {
        private FarmerDao farmerDao;

        InsertAsyncTask(FarmerDao dao) {
            farmerDao = dao;
        }

        @Override
        protected Void doInBackground(final Farmer... params) {
            farmerDao.insert(params[0]);
            return null;
        }
    }
}