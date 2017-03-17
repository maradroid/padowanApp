package com.padowan.app.model.interactors.team_interactor;

import com.padowan.app.base.BaseInteractor;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.interactors.team_interactor.listener.TeamListener;

import java.util.List;

import rx.Observable;


/**
 * Created by Korisnik on 14.3.2017..
 */

public interface TeamInteractor extends BaseInteractor{
    void getTeams(final TeamListener listenerTeam);

    Observable<List<Team>> getTeamObservable();
}
