package com.padowan.app.activites.rx_subject.presenter;

import com.padowan.app.R;
import com.padowan.app.model.data_model.Player;

import butterknife.OnClick;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Created by Korisnik on 20.3.2017..
 */

public class RxSubjectBus {
    private final Subject<Player, Player> bus = new SerializedSubject<>(PublishSubject.<Player>create());
    public void send(Player o) {
        bus.onNext(o);
    }

    public Observable<Player> toObservable(){
        return bus;
    }

    @OnClick(R.id.btn_show_player_names)
    public void onButtonClicked(){

    }
}

