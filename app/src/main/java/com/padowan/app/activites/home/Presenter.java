package com.padowan.app.activites.home;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.utils.RetroUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.button;
import static android.R.attr.data;
import static android.R.attr.name;

/**
 * Created by Mario Bat on 1.3.2017..
 */
public class Presenter extends MainActivity{

    Call<List<Player>> callPlayer;
    Call<List<Crime>> callCrime;
    Call<List<Team>> callTeam;

    //prosljeđeni interface mora biti final jer mu se pristupa iz anonimne klase
    public void getPlayers(final CallLog listenerPlayer) {
        callPlayer = RetroUtil.getService().readPlayer();
        callPlayer.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                List<Player> responsePlayerList = response.body();
                //listener.onPlayerResponse(responseList);
                Player worstPlayer = responsePlayerList.get(0);

                for (Player tempPlayer : responsePlayerList) {
                    if (worstPlayer.getArrestCount() < tempPlayer.getArrestCount()) {
                        worstPlayer = tempPlayer;
                    }
                }
                listenerPlayer.onPlayerResponse(worstPlayer.getName());
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                listenerPlayer.onFailure(t.getMessage());
            }
        });
    }

    public void getCrime (final CallLog listenerCrime) {
        callCrime = RetroUtil.getService().readCrime();
        callCrime.enqueue(new Callback<List<Crime>>() {
            @Override
            public void onResponse(Call<List<Crime>> call, Response<List<Crime>> response) {
                List<Crime>  responseCrimeList = response.body();

                Collections.sort(responseCrimeList, new Comparator<Crime>() {
                    @Override
                    public int compare(Crime o1, Crime o2) {
                        return Integer.valueOf(o1.getArrestCount()).compareTo(o2.getArrestCount());
                    }
                });
                listenerCrime.onCrimeResponse(responseCrimeList.get(0).getCategory());
            }

            @Override
            public void onFailure(Call<List<Crime>> call, Throwable t) {
                listenerCrime.onFailure(t.getMessage());
            }
        });
    }

    public void getTeam(final CallLog listenerTeam) {
        callTeam = RetroUtil.getService().readTeam();
        callTeam.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                List<Team> responseTeamList = response.body();

                Collections.sort(responseTeamList, new Comparator<Team>() {
                    @Override
                    public int compare(Team o1, Team o2) {
                        return Integer.valueOf(o2.getArrestCount()).compareTo(o2.getArrestCount());
                    }
                });
                listenerTeam.onCrimeResponse(responseTeamList.get(0).getTeam());
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                listenerTeam.onFailure(t.getMessage());
            }
        });
    }
    
}
