package com.padowan.app.activites.rx_example;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;

import java.util.List;

/**
 * Created by Korisnik on 20.3.2017..
 */

public interface RxListView {
    void showErrorMessage (String error);
    void onCrime(List<Crime> crime);
    void onCrimes(Crime crime);
    void onCrimeNumber(int number);
    void onCrimeName(String crime);
    void onPlayer(List<Player> playerList);
}
