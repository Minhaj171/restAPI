package com.example.restapi.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restapi.R;
import com.example.restapi.viewmodel.PlayerBioViewModel;

public class PlayerBioFragment extends Fragment {

    private PlayerBioViewModel mViewModel;

    public static PlayerBioFragment newInstance() {
        return new PlayerBioFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.player_bio_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PlayerBioViewModel.class);
        // TODO: Use the ViewModel
    }

}