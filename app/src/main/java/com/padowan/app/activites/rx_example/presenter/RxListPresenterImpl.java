package com.padowan.app.activites.rx_example.presenter;

import com.padowan.app.activites.rx_example.RxListView;
import com.padowan.app.base.BasePresenter;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractor;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.padowan.app.model.interactors.crime_interactor.listener.CrimeListener;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractor;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractorImpl;
import com.padowan.app.model.interactors.player_interactor.listener.PlayerListener;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Korisnik on 20.3.2017..
 */

public class RxListPresenterImpl implements RxListPresenter, CrimeListener, BasePresenter, PlayerListener {

    private CrimeInteractor crimeInteractor;
    private PlayerInteractor playerInteractor;
    private RxListView rxListView;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public int counter = 0;

    public RxListPresenterImpl(RxListView rxListView) {
        this.rxListView = rxListView;
        crimeInteractor = new CrimeInteractorImpl();
        playerInteractor = new PlayerInteractorImpl();
    }

    @Override
    public void stopCall() {
        crimeInteractor.stop();
        playerInteractor.stop();
    }

    @Override
    public void onCrimeSuccess(final List<Crime> crime) {
        //rxDefer(crime);
        //rxFrom(crime);
        //rxInterval(crime);
        //rxTimer(crime);
        //rxSubject(crime);
    }

    @Override
    public void onAllPlayerCrimeSuccess(List<Crime> crimes) {
        return;
    }

    @Override
    public void onDataFailure(String error) {
        rxListView.showErrorMessage(error);
    }

    @Override
    public void getCrimes() {
        crimeInteractor.getCrimes(this);
    }

    @Override
    public void getPlayers() {
        playerInteractor.getPlayers(this);
    }

    @Override
    public void stopClick() {
        unsubscribeSubscription();
    }

    @Override
    public void onYearPlayerCrime(List<Player> players, int page) {
        return;
    }

    @Override
    public void onPlayerSuccess(List<Player> player) {
        rxListView.onPlayer(player);
    }

    private void rxDefer(final List<Crime> crime){
        addSubscription(Observable.defer(new Func0<Observable<List<Crime>>>() {
            @Override
            public Observable<List<Crime>> call() {
                if (crime != null && !crime.isEmpty()) {
                    Collections.sort(crime, new Comparator<Crime>() {
                        @Override
                        public int compare(Crime o1, Crime o2) {
                            return o1.getCategory().compareTo(o2.getCategory());
                        }
                    });
                }
                return Observable.just(crime);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Crime>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        rxListView.showErrorMessage("Error!");
                        unsubscribeSubscription();
                    }

                    @Override
                    public void onNext(List<Crime> crimeList) {
                        rxListView.onCrime(crimeList);
                    }
                }));
    }

    private void rxFrom(final List<Crime> crime) {
        addSubscription(Observable.from(crime)
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<Crime, Observable<Crime>>() {
                    @Override
                    public Observable<Crime> call(Crime crimes) {
                        crimes.setCategory(crimes.getCategory() + " Add some string");
                        return Observable.just(crimes);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Crime>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        rxListView.showErrorMessage("Error!");
                        unsubscribeSubscription();
                    }

                    @Override
                    public void onNext(Crime crime) {
                        rxListView.onCrimes(crime);
                    }
                }));
    }

    private void rxInterval(final List<Crime> crime){
        //final int counter = 0;
        addSubscription(Observable
                .interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        rxListView.showErrorMessage("Error!");
                        unsubscribeSubscription();
                    }

                    @Override
                    public void onNext(Long aLong) {
                        if (counter <= crime.size() - 1) {
                            rxListView.onCrimeName(crime.get(counter).getCategory());
                            counter += 1;
                        }
                    }
                }));
    }

    private void rxTimer(final List<Crime> crime) {
        addSubscription(Observable.timer(3, TimeUnit.SECONDS, Schedulers.io())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        rxListView.showErrorMessage(e.getMessage());
                        unsubscribeSubscription();
                    }

                    @Override
                    public void onNext(Long aLong) {
                        rxListView.onCrime(crime);
                    }
                }));
    }

    private void addSubscription(Subscription subscription){
        if(compositeSubscription == null || compositeSubscription.isUnsubscribed())
            compositeSubscription = new CompositeSubscription();
        compositeSubscription.add(subscription);
    }

    private void unsubscribeSubscription(){
        compositeSubscription.unsubscribe();
    }
}


