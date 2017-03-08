package com.padowan.app.activites.list;

import com.padowan.app.activites.list.adapter.ListRecyclerTeamWraper;
import com.padowan.app.activites.list.adapter.ListRecyclerWraper;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.utils.RetroUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Korisnik on 3.3.2017..
 */

public class RecyclerViewPresenter {

    private Call<List<Crime>> callPlayerCrimes;
    private  Call<List<Crime>> callAllPlayerCrimes;
    private Call<List<Team>> callAllTeams;

    public void getPlayerCrimes(final PlayerCrimesListener listener, String name) {
        callPlayerCrimes = RetroUtil.getService().readAllCrimes(name);
        callPlayerCrimes.enqueue(new Callback<List<Crime>>() {
            @Override
            public void onResponse(Call<List<Crime>> call, Response<List<Crime>> response) {
                listener.onSuccessPlayerCrime(response.body());
            }

            @Override
            public void onFailure(Call<List<Crime>> call, Throwable t) {
                listener.onFail(t.getMessage());
            }
        });
    }

    public void getAllCrimes(final PlayerCrimesListener listener) {
        callAllPlayerCrimes = RetroUtil.getService().readCrime();
        callAllPlayerCrimes.enqueue(new Callback<List<Crime>>() {
            @Override
            public void onResponse(Call<List<Crime>> call, Response<List<Crime>> response) {

                Collections.sort(response.body(), new Comparator<Crime>() {
                    @Override
                    public int compare(Crime o1, Crime o2) {
                        return o1.getCategory().compareTo(o2.getCategory());
                    }
                });

                List<ListRecyclerWraper> recyclerList = new ArrayList<ListRecyclerWraper>();
                char firstLetter = '$';

                for(Crime crime : response.body()) {

                    if (crime.getCategory().charAt(0) != firstLetter) {
                        firstLetter = crime.getCategory().charAt(0);
                        recyclerList.add(new ListRecyclerWraper(String.valueOf(firstLetter), ListRecyclerWraper.TYPE_HEADER));
                    }
                    recyclerList.add(new ListRecyclerWraper(crime, ListRecyclerWraper.TYPE_ITEM));

                }
                listener.onSuccessCrime(recyclerList);
            }

            @Override
            public void onFailure(Call<List<Crime>> call, Throwable t) {
                listener.onFail(t.getMessage());
            }
        });
    }

    public void getAllTeams(final PlayerCrimesListener listener){
        callAllTeams = RetroUtil.getService().readTeam();
        callAllTeams.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                List<Team> responseTeamList = response.body();

                Collections.sort(responseTeamList, new Comparator<Team>() {
                    @Override
                    public int compare(Team o1, Team o2) {
                        return Integer.valueOf(o1.getArrestCount()).compareTo(o2.getArrestCount());
                    }
                });

                List<ListRecyclerTeamWraper> recyclerTeamList = new ArrayList<ListRecyclerTeamWraper>();

                for(Team team : responseTeamList){
                    if (team.getArrestCount() <= 10) {
                        recyclerTeamList.add(new ListRecyclerTeamWraper(team, ListRecyclerTeamWraper.TYPE_WHITE));

                    }else if(team.getArrestCount() > 10 && team.getArrestCount() <= 20){
                        recyclerTeamList.add(new ListRecyclerTeamWraper(team, ListRecyclerTeamWraper.TYPE_YELLOW));

                    }else if(team.getArrestCount() > 20 && team.getArrestCount() <= 30){
                        recyclerTeamList.add(new ListRecyclerTeamWraper(team, ListRecyclerTeamWraper.TYPE_ORANGE));

                    }else{
                        recyclerTeamList.add(new ListRecyclerTeamWraper(team, ListRecyclerTeamWraper.TYPE_RED));
                    }
                }
                listener.onSuccessTeam(recyclerTeamList);
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                listener.onFail(t.getMessage());
            }
        });
    }
}

