package com.padowan.app.activites.list;

import com.padowan.app.activites.list.adapter.ListRecyclerTeamWraper;
import com.padowan.app.activites.list.adapter.ListRecyclerWraper;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;

import java.util.List;

/**
 * Created by Korisnik on 6.3.2017..
 */
public interface ListView {
    void onAllCrimes(List<ListRecyclerWraper> crimeList);
    void onTeamCrimes(List<ListRecyclerTeamWraper> teamList);
    void onPlayerCrimes(List<Crime> crimeList);
    void chooseCrimesAdapter();
    void chooseTemasAdapter();
    void choosePlayerCriemsAdapter();
    void showErrorMessage(String error);
}
