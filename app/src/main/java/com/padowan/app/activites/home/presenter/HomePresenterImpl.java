package com.padowan.app.activites.home.presenter;

import com.padowan.app.activites.home.HomeModule;
import com.padowan.app.activites.home.HomeView;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.ResponseContainer;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.interactors.home_interactor.HomeInteracotrImpl;
import com.padowan.app.model.interactors.home_interactor.HomeInteractor;
import com.padowan.app.model.interactors.home_interactor.listener.HomeListener;

import javax.inject.Inject;

import dagger.Module;

/**
 * Created by Mario Bat on 1.3.2017..
 */

public class HomePresenterImpl implements HomePresenter,HomeListener {

    private HomeView homeView;
    private HomeInteractor homeInteractor;

    @Inject
    public HomePresenterImpl(HomeView homeView, HomeInteractor homeInteractor) {
        this.homeView = homeView;
        this.homeInteractor = homeInteractor;
        //homeInteractor = new HomeInteracotrImpl();
    }

    @Override
    public void onDataSuccess(ResponseContainer container) {
        Player worstPlayer = container.getPlayer().get(0);
        for (Player tempPlayer : container.getPlayer()) {
            if (worstPlayer.getArrestCount() < tempPlayer.getArrestCount()) {
                worstPlayer = tempPlayer;
            }
            homeView.onPlayer(worstPlayer.getName());
        }

        Team worstTeam = container.getTeam().get(0);
        for (Team tempTeam : container.getTeam()) {
            if (worstTeam.getArrestCount() < tempTeam.getArrestCount()) {
                worstTeam = tempTeam;
            }
            homeView.onTeam(worstTeam.getTeamName());
        }
        Crime topCrimes = container.getCrime().get(0);
       // if (container.getPlayer() != null && !container.getPlayer().isEmpty()) {
        for (Crime tempCrime : container.getCrime()) {
            if (topCrimes.getArrestCount() < tempCrime.getArrestCount()) {
                topCrimes = tempCrime;
            }
            homeView.onCrime(topCrimes.getCategory());
        }
    }

    @Override
    public void worstData() {
        homeInteractor.getData(this);
    }

    @Override
    public void onClickCall() {
        worstData();
    }

    @Override
    public void onDataFailure(String error) {
      homeView.showErrorMessage(error);
    }

    @Override
    public void stopCall() {
        homeInteractor.stop();
    }
}
