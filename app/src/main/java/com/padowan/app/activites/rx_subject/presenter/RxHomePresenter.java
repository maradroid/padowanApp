package com.padowan.app.activites.rx_subject.presenter;

import com.padowan.app.model.data_model.Player;

import rx.Observable;

/**
 * Created by Korisnik on 20.3.2017..
 */

public interface RxHomePresenter {
    void observePlayers(Observable<Player> observablePlayer);
    void unsubscribeSubscription();
}
