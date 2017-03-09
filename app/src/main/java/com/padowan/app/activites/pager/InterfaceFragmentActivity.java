package com.padowan.app.activites.pager;

import com.padowan.app.model.data_model.Player;

import java.util.List;

/**
 * Created by Korisnik on 9.3.2017..
 */

public interface InterfaceFragmentActivity {
    void sendData(List<String> playerList);
    void sendNameToActivity(String startYear, String endYear);
}
