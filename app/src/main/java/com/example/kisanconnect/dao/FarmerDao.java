package com.example.kisanconnect.dao;

import com.example.kisanconnect.models.Farmer;
import java.util.List;

public interface FarmerDao {
    // Define CRUD methods here
    void insertFarmer(Farmer farmer);
    Farmer getFarmerById(int id);
    List<Farmer> getAllFarmers();
    void updateFarmer(Farmer farmer);
    void deleteFarmer(int id);
}
