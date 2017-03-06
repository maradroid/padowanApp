package com.padowan.app.activites.list;

import com.padowan.app.model.data_model.Crime;

import java.util.List;

/**
 * Created by Korisnik on 6.3.2017..
 */
public interface PlayerCrimesListener {
    void onSuccess(List<Crime> crimeList);
    void onFail(String error);
}
