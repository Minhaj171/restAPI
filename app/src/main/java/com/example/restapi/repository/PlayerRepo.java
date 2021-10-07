package com.example.restapi.repository;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.restapi.endpoint.IPlayer;
import com.example.restapi.model.DemoBaseModel;
import com.example.restapi.model.DemoSubModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Md Minhajul Islam on 10/6/2021.
 */
public class PlayerRepo {
    private MutableLiveData<List<DemoSubModel>> demoData;
    private IPlayer iPlayer;

    public LiveData<List<DemoSubModel>> getDemoData() {
        if (demoData == null) {
            demoData = new MutableLiveData<>();
            loadOrders();
        }
        return demoData;
    }

    private void loadOrders() {
        Call<DemoBaseModel> call = iPlayer.getData("5TEVUIUOYCmYjZfLxHUN7Gkzgjk9PQLteAEU6PkFiRxZEef9XZdAcQHsgMKE");
        call.enqueue(new Callback<DemoBaseModel>() {
            @Override
            public void onResponse(@NonNull Call<DemoBaseModel> call, Response<DemoBaseModel> response) {
                assert response.body() != null;
                List<DemoSubModel> data = response.body().getData();
                demoData.setValue(data);
            }

            @Override
            public void onFailure(Call<DemoBaseModel> call, Throwable t) {

            }
        });
    }


}
