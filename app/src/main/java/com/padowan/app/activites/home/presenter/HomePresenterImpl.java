package com.padowan.app.activites.home.presenter;

import com.padowan.app.activites.home.HomeView;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractor;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractorImpl;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractor;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.padowan.app.model.interactors.crime_interactor.listener.CrimeListener;
import com.padowan.app.model.interactors.player_interactor.listener.PlayerListener;
import com.padowan.app.model.interactors.team_interactor.listener.TeamListener;
import com.padowan.app.model.interactors.team_interactor.TeamInteractor;
import com.padowan.app.model.interactors.team_interactor.TeamInteractorImpl;

import java.util.List;


/**
 * Created by Mario Bat on 1.3.2017..
 */
public class HomePresenterImpl implements HomePresenter, PlayerListener, TeamListener, CrimeListener {

    private HomeView homeView;
    private TeamInteractor teamInteractor;
    private CrimeInteractor crimeInteractor;
    private PlayerInteractor playerInteractor;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;
        teamInteractor = new TeamInteractorImpl();
        crimeInteractor = new CrimeInteractorImpl();
        playerInteractor = new PlayerInteractorImpl();
    }

    public void stopCall(){
        if (teamInteractor != null)
            teamInteractor.stop();
        if (crimeInteractor != null)
            crimeInteractor.stop();
        if (playerInteractor != null)
            playerInteractor.stop();
    }

    //prosljeđeni interface mora biti final jer mu se pristupa iz anonimne klase

    @Override
    public void worstPlayer() {
        playerInteractor.getPlayers(this);
    }

    @Override
    public void topCrime() {
        crimeInteractor.getCrimes(this);
    }
    @Override
    public void worstTeam() {
        teamInteractor.getTeams(this);
    }

    @Override
    public void onDataFailure(String error) {
      homeView.showErrorMessage(error);
    }

    @Override
    public void onPlayerSuccess(List<Player> player) {
        if (player != null && !player.isEmpty()) {
            Player worstPlayer = player.get(0);
            for (Player tempPlayer : player) {
                if (worstPlayer.getArrestCount() < tempPlayer.getArrestCount()) {
                    worstPlayer = tempPlayer;
                }
            }
            homeView.onPlayer(worstPlayer.getName());
        }
    }

    @Override
    public void onYearPlayerCrime(List<Player> players) {
        return ;
    }

    @Override
    public void onTeamSuccess(List<Team> team) {
        if (team != null && !team.isEmpty()) {
            Team worstTeam = team.get(0);
            for (Team tempTeam : team) {
                if (worstTeam.getArrestCount() < tempTeam.getArrestCount()) {
                    worstTeam = tempTeam;
                }
            }
            homeView.onTeam(worstTeam.getTeamName());
        }
    }

    @Override
    public void onCrimeSuccess(List<Crime> crime) {
        if (crime != null && !crime.isEmpty()) {
            Crime topCrimes = crime.get(0);
            for (Crime tempCrime : crime) {
                if (topCrimes.getArrestCount() < tempCrime.getArrestCount()) {
                    topCrimes = tempCrime;
                }
            }
            homeView.onCrime(topCrimes.getCategory());
        }
    }

    @Override
    public void onAllPlayerCrimeSuccess(List<Crime> crimes) {
        return;
    }
}
