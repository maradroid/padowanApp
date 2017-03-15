package com.padowan.app.model.interactors.player_interactor;

import com.padowan.app.base.BaseInteractor;
import com.padowan.app.model.interactors.player_interactor.listener.BasePlayerListener;
import com.padowan.app.model.interactors.player_interactor.listener.PlayerListener;

import java.util.Map;


/**
 * Created by Korisnik on 14.3.2017..
 */

public interface PlayerInteractor extends BaseInteractor{
    void getPlayers(final BasePlayerListener listenerPlayer);
    void getAllPlayerCrimes(PlayerListener playerListener, Map<String, String> date);
}
