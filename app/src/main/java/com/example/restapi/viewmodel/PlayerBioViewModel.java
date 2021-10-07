package com.example.restapi.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.restapi.model.DemoBaseModel;
import com.example.restapi.model.DemoSubModel;
import com.example.restapi.repository.PlayerRepo;

import java.util.List;

public class PlayerBioViewModel extends ViewModel {
    PlayerRepo playerRepo = new PlayerRepo();

    public LiveData<List<DemoSubModel>> getData(){
        return playerRepo.getDemoData();
    }
}