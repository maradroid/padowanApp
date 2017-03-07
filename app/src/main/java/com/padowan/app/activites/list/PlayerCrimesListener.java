package com.padowan.app.activites.list;

import com.padowan.app.activites.list.adapter.ListRecyclerTeamWraper;
import com.padowan.app.activites.list.adapter.ListRecyclerWraper;
import com.padowan.app.model.data_model.Crime;

import java.util.List;

/**
 * Created by Korisnik on 6.3.2017..
 */
public interface PlayerCrimesListener {
    void onSuccessCrime(List<ListRecyclerWraper> crimeList);
    void onSuccessTeam(List<ListRecyclerTeamWraper> teamList);
    void onSuccessPlayerCrime(List<Crime> crimeList);
    void onFail(String error);
}
