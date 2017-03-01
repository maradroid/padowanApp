package com.padowan.app.model.utils;

import com.padowan.app.model.data_model.Player;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mario Bat on 1.3.2017..
 */

public interface WebAPIService {

    String PLAYER = "player";

    @GET(PLAYER)
    Call<List<Player>> readPlayer();

}
