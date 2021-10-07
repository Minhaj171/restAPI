package com.example.restapi.endpoint;

import com.example.restapi.model.DataModel;
import com.example.restapi.model.DemoBaseModel;
import com.example.restapi.model.PlayerInformation;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Md Minhajul Islam on 10/6/2021.
 */
public interface IPlayer {
    @GET("players")
    Call<DataModel> getPlayers(@Query("api_token") String token);

    @GET("continents")
    Call<DemoBaseModel> getData(@Query("api_token") String token);


}
