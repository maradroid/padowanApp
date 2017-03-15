package com.padowan.app.activites.pager.activity;

import com.padowan.app.model.data_model.Player;

import java.util.List;

/**
 * Created by Korisnik on 15.3.2017..
 */

public interface PagerView {
    void onYearlyPlayerCrime(List<Player> playerYearCrime, int page);
    void showErrorMessage(String error);
}
