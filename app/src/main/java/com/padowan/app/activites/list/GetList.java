package com.padowan.app.activites.list;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.Team;

import java.util.List;

/**
 * Created by Korisnik on 14.3.2017..
 */

public interface GetList {
    void onPlayerList(List<Player> player);
    void onTeamList(List<Team> team);
    void onCrimeList(List<Crime> crime);
}
