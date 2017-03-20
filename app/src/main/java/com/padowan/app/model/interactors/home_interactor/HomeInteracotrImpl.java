package com.padowan.app.model.interactors.home_interactor;

import com.padowan.app.base.BaseInteractorImpl;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.ResponseContainer;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractor;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.padowan.app.model.interactors.home_interactor.listener.HomeListener;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractor;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractorImpl;
import com.padowan.app.model.interactors.team_interactor.TeamInteractor;
import com.padowan.app.model.interactors.team_interactor.TeamInteractorImpl;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func3;
import rx.schedulers.Schedulers;


/**
 * Created by Korisnik on 17.3.2017..
 */

public class HomeInteracotrImpl extends BaseInteractorImpl implements HomeInteractor {

    private CrimeInteractor crimeInteractor = new CrimeInteractorImpl();
    private PlayerInteractor playerInteractor = new PlayerInteractorImpl();
    private TeamInteractor teamInteractor = new TeamInteractorImpl();


    @Override
    public void getData(final HomeListener homeListener) {
        addSubscription(Observable.zip(crimeInteractor.getCrimesObservable(), playerInteractor.getPlayerObservable(), teamInteractor.getTeamObservable(), new Func3<List<Crime>, List<Player>, List<Team>, ResponseContainer>() {
            @Override
            public ResponseContainer call(List<Crime> crimes, List<Player> playerList, List<Team> teams) {
                return new ResponseContainer(teams, crimes, playerList);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ResponseContainer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        stop();
                        homeListener.onDataFailure(e.getMessage());
                    }

                    @Override
                    public void onNext(ResponseContainer container) {
                        homeListener.onDataSuccess(container);
                    }
                }));
    }

    @Override
    public void stop() {
        unsubscribeSubscription();
    }
}

