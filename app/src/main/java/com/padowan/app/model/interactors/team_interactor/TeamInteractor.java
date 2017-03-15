package com.padowan.app.model.interactors.team_interactor;

import com.padowan.app.base.BaseInteractor;
import com.padowan.app.model.interactors.team_interactor.listener.TeamListener;


/**
 * Created by Korisnik on 14.3.2017..
 */

public interface TeamInteractor extends BaseInteractor{
    void getTeams(final TeamListener listenerTeam);
}
