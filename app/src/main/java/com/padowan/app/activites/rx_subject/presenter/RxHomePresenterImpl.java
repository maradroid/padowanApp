package com.padowan.app.activites.rx_subject.presenter;

import com.padowan.app.activites.rx_subject.RxHomeView;
import com.padowan.app.base.BasePresenter;
import com.padowan.app.model.data_model.Player;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Korisnik on 20.3.2017..
 */

public class RxHomePresenterImpl implements BasePresenter, RxHomePresenter {

    private RxHomeView rxHomeView;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public RxHomePresenterImpl(RxHomeView rxHomeView) {
        this.rxHomeView = rxHomeView;
        observePlayers(RxSubjectBus.getBus());
    }

    @Override
    public void stopCall() {return ;
    }


    @Override
    public void observePlayers(Observable<Player> observablePlayer) {
        addSubscription(observablePlayer.observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Player>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(Player player) {
                rxHomeView.onPlayer(player.getName());
            }
        }));
    }

    private void addSubscription (Subscription subscription){
        if (compositeSubscription == null || compositeSubscription.isUnsubscribed())
                compositeSubscription = new CompositeSubscription();
        compositeSubscription.add(subscription);
    }

    public void unsubscribeSubscription(){
        compositeSubscription.unsubscribe();
    }
}
