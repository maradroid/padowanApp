package com.padowan.app.activites.rx_subject.presenter;

import com.padowan.app.model.data_model.Player;
import rx.Observable;
import rx.subjects.PublishSubject;


/**
 * Created by Korisnik on 20.3.2017..
 */

public abstract class RxSubjectBus {
    private static final PublishSubject<Player> bus =  PublishSubject.create();

    public static Observable<Player> getBus(){
        return bus;
    }

    public static void send(Player player){
        if(bus.hasObservers())
            bus.onNext(player);
    }
}

