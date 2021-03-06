package com.padowan.app.activites.pager.presenter;

import com.padowan.app.activites.pager.activity.PagerView;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractor;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractorImpl;
import com.padowan.app.model.interactors.player_interactor.listener.PlayerListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Korisnik on 9.3.2017..
 */

public class PagerPresenterImpl implements PlayerListener, PagerPresenter{

    private PagerView pagerView;
    private PlayerInteractor playerInteractor;

    @Inject
    public PagerPresenterImpl(PagerView pagerView, PlayerInteractor playerInteractor) {
        this.pagerView = pagerView;
        this.playerInteractor = playerInteractor;
        //playerInteractor = new PlayerInteractorImpl();
    }

    private Map<String, String> getUrl(String startDate, String endDate){

        Map<String, String> urlMap = new HashMap<>();

        urlMap.put("start_date", startDate);
        urlMap.put("end_date", endDate);

        return urlMap;
    }

    @Override
    public void onDataFailure(String error) {
        pagerView.showErrorMessage(error);
    }

    @Override
    public void allYearCrimes(String startDate, String endDate, int page) {
        playerInteractor.getAllPlayerCrimes(this, getUrl(startDate, endDate), page);
    }

    @Override
    public void onPlayerSuccess(List<Player> player) {
        return ;
    }

    @Override
    public void onYearPlayerCrime(List<Player> players, int page) {
        if (players != null && !players.isEmpty())
        pagerView.onYearlyPlayerCrime(players, page);
    }

    @Override
    public void stopCall() {
        playerInteractor.stop();
    }
}
