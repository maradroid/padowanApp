package com.padowan.app.utils;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.Team;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by Mario Bat on 1.3.2017..
 */

public interface WebAPIService {

    String PLAYER = "player";
    String TEAM = "team";
    String CRIME = "crime";
    String ALLCRIMES = "player/topCrimes/{name}";
    String YEAR_ARREST ="player";

    @GET(PLAYER)
    Observable<List<Player>> readPlayer();

    @GET(TEAM)
    Observable<List<Team>> readTeam();

    @GET(CRIME)
    Observable<List<Crime>> readCrime();

    @GET(ALLCRIMES)
    Observable<List<Crime>> readAllCrimes(@Path("name") String name);

    @GET(YEAR_ARREST)
    Observable<List<Player>> readPlayerYearCrimes(@QueryMap() Map<String, String> url);
}
