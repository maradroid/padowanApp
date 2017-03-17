package com.padowan.app.activites.home.presenter;

import com.padowan.app.activites.home.HomeView;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.ResponseContainer;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.interactors.crime_interactor.listener.BaseCrimeListener;
import com.padowan.app.model.interactors.home_interactor.HomeInteracotrImpl;
import com.padowan.app.model.interactors.home_interactor.HomeInteractor;
import com.padowan.app.model.interactors.home_interactor.listener.HomeListener;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractor;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractorImpl;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractor;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.padowan.app.model.interactors.player_interactor.listener.BasePlayerListener;
import com.padowan.app.model.interactors.team_interactor.listener.TeamListener;
import com.padowan.app.model.interactors.team_interactor.TeamInteractor;
import com.padowan.app.model.interactors.team_interactor.TeamInteractorImpl;

import java.util.List;


/**
 * Created by Mario Bat on 1.3.2017..
 */
public class HomePresenterImpl implements HomePresenter,HomeListener {

    private HomeView homeView;
    private HomeInteractor homeInteractor;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        homeInteractor = new HomeInteracotrImpl();
    }

    @Override
    public void onDataSuccess(ResponseContainer container) {
        if (container.getPlayer() != null && !container.getPlayer().isEmpty()) {
            Player worstPlayer = container.getPlayer().get(0);
            for (Player tempPlayer : container.getPlayer()) {
                if (worstPlayer.getArrestCount() < tempPlayer.getArrestCount()) {
                    worstPlayer = tempPlayer;
                }
            }
            homeView.onPlayer(worstPlayer.getName());
        }

        if (container.getTeam() != null && !container.getTeam().isEmpty()) {
            Team worstTeam = container.getTeam().get(0);
            for (Team tempTeam : container.getTeam()) {
                if (worstTeam.getArrestCount() < tempTeam.getArrestCount()) {
                    worstTeam = tempTeam;
                }
            }
            homeView.onTeam(worstTeam.getTeamName());
        }
        if (container.getCrime() != null && !container.getCrime().isEmpty()) {
            Crime topCrimes = container.getCrime().get(0);
            for (Crime tempCrime : container.getCrime()) {
                if (topCrimes.getArrestCount() < tempCrime.getArrestCount()) {
                    topCrimes = tempCrime;
                }
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
