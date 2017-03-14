package com.padowan.app.activites.home;

import com.padowan.app.model.data_model.Player;

import java.util.List;

/**
 * Created by Mario Bat on 1.3.2017..
 */

public interface HomeView {
    void onPlayer(String player);
    void onTeam(String team);
    void onCrime(String crime);
    void showErrorMessage(String error);
}
