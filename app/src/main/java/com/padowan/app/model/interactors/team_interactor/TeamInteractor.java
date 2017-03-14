package com.padowan.app.model.interactors.team_interactor;

import com.padowan.app.model.interactors.team_interactor.listener.TeamListener;


/**
 * Created by Korisnik on 14.3.2017..
 */

public interface TeamInteractor {
    void getTeams(final TeamListener listenerTeam);
    void stop();
}
