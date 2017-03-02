package com.padowan.app.model.utils;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mario Bat on 1.3.2017..
 */

public interface WebAPIService {

    String PLAYER = "player";
    String TEAM = "team";
    String CRIME = "crime";

    @GET(PLAYER)
    Call<List<Player>> readPlayer();

    @GET(TEAM)
    Call<List<Team>> readTeam();

    @GET(CRIME)
    Call<List<Crime>> readCrime();

}
