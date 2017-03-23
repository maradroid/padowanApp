package com.padowan.app.model.interactors.team_interactor;

import com.padowan.app.base.BaseInteractorImpl;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.interactors.team_interactor.listener.TeamListener;
import com.padowan.app.utils.RetroUtil;
import com.padowan.app.utils.ServiceModule;
import com.padowan.app.utils.WebAPIService;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Korisnik on 14.3.2017..
 */

public class TeamInteractorImpl extends BaseInteractorImpl implements TeamInteractor {

    @Inject
    WebAPIService webAPIService;

    @Inject
    public TeamInteractorImpl() {
    }

    @Override
    public void getTeams(final TeamListener listenerTeam) {
        addSubscription(getTeamObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Team>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        stop();
                        listenerTeam.onDataFailure("Error!");
                    }

                    @Override
                    public void onNext(List<Team> teams) {
                        listenerTeam.onTeamSuccess(teams);
                    }
                }));
    }

    @Override
    public Observable<List<Team>> getTeamObservable() {
        return webAPIService.readTeam();
    }

    @Override
    public void stop() {
        unsubscribeSubscription();
    }
}
