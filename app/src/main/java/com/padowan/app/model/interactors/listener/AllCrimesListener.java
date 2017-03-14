package com.padowan.app.model.interactors.listener;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Team;

import java.util.List;

/**
 * Created by Korisnik on 14.3.2017..
 */

public interface AllCrimesListener {
    void onAllCrimeSuccess (List<Crime> crime);
    void onAllTeamSuccess(List<Team> team);
}
