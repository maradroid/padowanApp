package com.padowan.app.model.interactors.team_interactor;

import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.interactors.team_interactor.listener.TeamListener;
import com.padowan.app.model.utils.RetroUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Korisnik on 14.3.2017..
 */

public class TeamInteractorImpl implements TeamInteractor {

    private Call<List<Team>> callTeam;

    @Override
    public void getTeams(final TeamListener listenerTeam){
        callTeam = RetroUtil.getService().readTeam();
        callTeam.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                listenerTeam.onTeamSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                listenerTeam.onDataFailure(t.getMessage());
            }
        });
    }

    @Override
    public void stop() {
        callTeam.cancel();
    }
}
