package com.padowan.app.model.interactors.player_interactor.listener;


import com.padowan.app.base.BaseInteractor;
import com.padowan.app.model.data_model.Player;

import java.util.List;

/**
 * Created by Korisnik on 14.3.2017..
 */

public interface PlayerListener extends BaseInteractor{
    void onPlayerSuccess(List<Player> player);
}
