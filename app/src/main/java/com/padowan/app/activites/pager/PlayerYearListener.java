package com.padowan.app.activites.pager;

import com.padowan.app.model.data_model.Player;

import java.util.List;

/**
 * Created by Korisnik on 9.3.2017..
 */

public interface PlayerYearListener {
    void onSuccessPlayerYearCrime(List<Player> playerYearList, int tag);
    void onFailure(String error);
    void onSuccessPlayeYearName(List<String> names, int tag);
}
