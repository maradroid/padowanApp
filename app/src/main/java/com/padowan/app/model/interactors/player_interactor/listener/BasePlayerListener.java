package com.padowan.app.model.interactors.player_interactor.listener;

import com.padowan.app.base.BaseListener;
import com.padowan.app.model.data_model.Player;

import java.util.List;

/**
 * Created by Korisnik on 15.3.2017..
 */

public interface BasePlayerListener extends BaseListener{
    void onPlayerSuccess(List<Player> player);
}
