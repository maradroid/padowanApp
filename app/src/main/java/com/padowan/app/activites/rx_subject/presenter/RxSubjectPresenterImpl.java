package com.padowan.app.activites.rx_subject.presenter;

import com.padowan.app.activites.rx_subject.RxSubjectView;
import com.padowan.app.base.BasePresenter;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractor;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractorImpl;
import com.padowan.app.model.interactors.player_interactor.listener.PlayerListener;

import java.util.List;

/**
 * Created by Korisnik on 20.3.2017..
 */

public class RxSubjectPresenterImpl implements PlayerListener, BasePresenter, RxSubjectPresenter{
    private PlayerInteractor playerInteractor;
    private RxSubjectView rxSubjectView;

    public RxSubjectPresenterImpl(RxSubjectView rxSubjectView) {
        this.rxSubjectView = rxSubjectView;
        playerInteractor = new PlayerInteractorImpl();
    }


    @Override
    public void onDataFailure(String error) {
    }

    @Override
    public void stopCall() {
        playerInteractor.stop();
    }

    @Override
    public void getPlayers() {
        playerInteractor.getPlayers(this);
    }

    @Override
    public void onYearPlayerCrime(List<Player> players, int page) {

    }

    @Override
    public void onPlayerSuccess(List<Player> player) {

    }
}
