package com.padowan.app.model.interactors.player_interactor;

import com.padowan.app.model.interactors.player_interactor.listener.PlayerListener;


/**
 * Created by Korisnik on 14.3.2017..
 */

public interface PlayerInteractor {
    void getPlayers(final PlayerListener listenerPlayer);
    void stop();
}
