package com.padowan.app.model.interactors.player_interactor;

import com.padowan.app.base.BaseInteractorImpl;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.interactors.player_interactor.listener.BasePlayerListener;
import com.padowan.app.model.interactors.player_interactor.listener.PlayerListener;
import com.padowan.app.utils.RetroUtil;
import com.padowan.app.utils.WebAPIService;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Korisnik on 14.3.2017..
 */

public class PlayerInteractorImpl extends BaseInteractorImpl implements PlayerInteractor {

    @Inject
    WebAPIService webAPIService;

    @Inject
    public PlayerInteractorImpl() {
    }

    @Override
    public void getPlayers(final BasePlayerListener listenerPlayer) {
        addSubscription(getPlayerObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Player>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        stop();
                        listenerPlayer.onDataFailure("Error!");
                    }

                    @Override
                    public void onNext(List<Player> players) {
                        listenerPlayer.onPlayerSuccess(players);
                    }
                }));
    }

    @Override
    public void getAllPlayerCrimes(final PlayerListener playerListener, Map<String, String> date, final int page) {
        addSubscription(getPlayerYearCrime(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Player>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        playerListener.onDataFailure("Error!");
                        stop();
                    }

                    @Override
                    public void onNext(List<Player> players) {
                        playerListener.onYearPlayerCrime(players, page);
                    }
                }));
    }

    @Override
    public Observable<List<Player>> getPlayerObservable() {
        return webAPIService.readPlayer();
    }

    @Override
    public Observable<List<Player>> getPlayerYearCrime(Map<String, String> date) {
        return webAPIService.readPlayerYearCrimes(date);
    }

    @Override
    public void stop() {
        unsubscribeSubscription();
    }
}
