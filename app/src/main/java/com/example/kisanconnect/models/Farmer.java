package com.example.kisanconnect.models;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.yourappname.models.Farmer;

import java.util.List;

@Dao
public interface FarmerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Farmer farmer);

    @Query("SELECT * FROM farmer WHERE aadhaarNumber = :aadhaar")
    Farmer getFarmerByAadhaar(String aadhaar);

    @Query("SELECT * FROM farmer")
    List<Farmer> getAllFarmers();
}