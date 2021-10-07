package com.example.restapi.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restapi.R;
import com.example.restapi.adapter.PlayerAdapter;
import com.example.restapi.databinding.PlayerBioFragmentBinding;
import com.example.restapi.endpoint.IPlayer;
import com.example.restapi.model.PlayerInformation;
import com.example.restapi.viewmodel.PlayerBioViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlayerBioFragment extends Fragment {

    private PlayerBioViewModel mViewModel;
    private PlayerBioFragmentBinding playerBioBinding;
    private IPlayer iPlayer;

    public static PlayerBioFragment newInstance() {
        return new PlayerBioFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        playerBioBinding =  PlayerBioFragmentBinding.inflate(inflater, container, false);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://cricket.sportmonks.com/api/v2.0/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        iPlayer = retrofit.create(IPlayer.class);

        return playerBioBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Call<List<PlayerInformation>> call = iPlayer.getPlayers("5TEVUIUOYCmYjZfLxHUN7Gkzgjk9PQLteAEU6PkFiRxZEef9XZdAcQHsgMKE");
//        call.enqueue(new Callback<List<PlayerInformation>>() {
//            @Override
//            public void onResponse(@NonNull Call<List<PlayerInformation>> call, @NonNull Response<List<PlayerInformation>> response) {
//                if (response.isSuccessful()){
//                    List<PlayerInformation> playerInfo = response.body();
//                    setPlayerBio(playerInfo);
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<List<PlayerInformation>> call, @NonNull Throwable t) {
//
//            }
//        });
    }

    private void setPlayerBio(List<PlayerInformation> playerInfo){
//        PlayerAdapter playerAdapter = new PlayerAdapter();
//        playerBioBinding.playerRecycler.setAdapter(playerAdapter);
//        playerBioBinding.playerRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
//        playerAdapter.updatePlayers(playerInfo);
    }

}