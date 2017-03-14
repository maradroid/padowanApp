package com.padowan.app.model.interactors.team_interactor.listener;

import com.padowan.app.base.BaseInteractor;
import com.padowan.app.model.data_model.Team;

import java.util.List;

/**
 * Created by Korisnik on 14.3.2017..
 */

public interface TeamListener extends BaseInteractor{
    void onTeamSuccess(List<Team> teamList);
}
