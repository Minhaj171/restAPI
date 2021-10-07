package com.example.restapi.model;

import java.util.List;

/**
 * Created by Md Minhajul Islam on 10/7/2021.
 */
public class DataModel {
    private List<PlayerInformation> playerInformations;

    public DataModel(List<PlayerInformation> playerInformations) {
        this.playerInformations = playerInformations;
    }

    public List<PlayerInformation> getPlayerInformations() {
        return playerInformations;
    }

    public void setPlayerInformations(List<PlayerInformation> playerInformations) {
        this.playerInformations = playerInformations;
    }
}
