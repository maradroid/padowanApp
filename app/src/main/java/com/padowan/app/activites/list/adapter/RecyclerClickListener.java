package com.padowan.app.activites.list.adapter;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.Team;

/**
 * Created by Korisnik on 6.3.2017..
 */

public interface RecyclerClickListener {
    void onRecyclerClick(Crime crime);
    void onRecyclerClickTeam(Team team);
    void onRecyclerClickPlayer(Player player);
}
