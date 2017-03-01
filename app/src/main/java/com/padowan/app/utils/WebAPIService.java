package com.padowan.app.utils;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mario Bat on 1.3.2017..
 */

public interface WebAPIService {

    String PLAYER = "player";

    @GET(PLAYER)
    Call<String> readPlayer();

}
