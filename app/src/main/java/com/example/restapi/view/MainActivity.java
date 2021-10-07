package com.example.restapi.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.restapi.R;
import com.example.restapi.adapter.ContinentsAdapter;
import com.example.restapi.adapter.PlayerAdapter;
import com.example.restapi.databinding.ActivityMainBinding;
import com.example.restapi.endpoint.IPlayer;
import com.example.restapi.model.DataModel;
import com.example.restapi.model.DemoBaseModel;
import com.example.restapi.model.DemoSubModel;
import com.example.restapi.model.PlayerInformation;
import com.example.restapi.viewmodel.PlayerBioViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    IPlayer iPlayer;
    private ActivityMainBinding mainBinding;
    private PlayerBioViewModel bioViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
//                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iPlayer = retrofit.create(IPlayer.class);

//        setRestApi();
        fetchDataFromViewModel();
    }

    private void fetchDataFromViewModel(){
//        bioViewModel.getData().observe(this, new Observer<List<DemoBaseModel>>() {
//            @Override
//            public void onChanged(List<DemoBaseModel> demoBaseModels) {
//                setDemo(demoBaseModels);
//            }
//        });
        bioViewModel.getData().observe(this, new Observer<List<DemoSubModel>>() {
            @Override
            public void onChanged(List<DemoSubModel> demoSubModels) {
                setDemo(demoSubModels);
            }
        });
    }

    private void setDemo(List<DemoSubModel> demoBaseModels) {
        ContinentsAdapter adapter = new ContinentsAdapter();
        mainBinding.continentsRecycler.setAdapter(adapter);
        mainBinding.continentsRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        DemoBaseModel baseDataClass = new DemoBaseModel(demoBaseModels);
        adapter.updateBaseData(baseDataClass.getData());

    }

    private void setContinents(List<DemoSubModel> data) {
        ContinentsAdapter adapter = new ContinentsAdapter();
        mainBinding.continentsRecycler.setAdapter(adapter);
        mainBinding.continentsRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        DemoBaseModel baseDataClass = new DemoBaseModel(data);
        adapter.updateBaseData(baseDataClass.getData());
    }

    private void setRestApi() {
        Call<DataModel> call = iPlayer.getPlayers("5TEVUIUOYCmYjZfLxHUN7Gkzgjk9PQLteAEU6PkFiRxZEef9XZdAcQHsgMKE");
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(@NonNull Call<DataModel> call, @NonNull Response<DataModel> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Data "+response.code(), Toast.LENGTH_SHORT).show();
                    assert response.body() != null;
                    List<PlayerInformation> playerInfo = response.body().getPlayerInformations();
                    setPlayerBio(playerInfo);
                }
                else {
                    Toast.makeText(getApplicationContext(), "No Data "+response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DataModel> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(), "No Response", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void setPlayerBio(List<PlayerInformation> playerInfo) {
        PlayerAdapter playerAdapter = new PlayerAdapter();
        mainBinding.playerRecycler.setAdapter(playerAdapter);
        mainBinding.playerRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        DataModel dataModel = new DataModel(playerInfo);
        playerAdapter.updatePlayers(dataModel.getPlayerInformations());
    }
}