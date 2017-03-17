package com.padowan.app.model.interactors.team_interactor;

import com.padowan.app.base.BaseInteractorImpl;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.interactors.team_interactor.listener.TeamListener;
import com.padowan.app.utils.RetroUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Korisnik on 14.3.2017..
 */

public class TeamInteractorImpl extends BaseInteractorImpl implements TeamInteractor {

    @Override
    public void getTeams(final TeamListener listenerTeam) {
        addSubscription(RetroUtil.getService().readTeam()
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
        return RetroUtil.getService().readTeam();
    }

    @Override
    public void stop() {
        unsubscribeSubscription();
    }
}
