package com.example.restapi.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restapi.databinding.PlayerRowBinding;
import com.example.restapi.model.PlayerInformation;

import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/6/2021.
 */
public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    private List<PlayerInformation> playerList;

    public void updatePlayers(List<PlayerInformation> playerList){
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PlayerRowBinding playerRowBinding = PlayerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(playerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PlayerInformation player = playerList.get(position);
        holder.bindView(player);
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        PlayerRowBinding playersBinding;
        public ViewHolder(@NonNull PlayerRowBinding playerRowBinding) {
            super(playerRowBinding.getRoot());
            this.playersBinding = playerRowBinding;
        }

        public void bindView(PlayerInformation player) {
            playersBinding.setPlayer(player);
            playersBinding.setException("N/a");
        }
    }
}
