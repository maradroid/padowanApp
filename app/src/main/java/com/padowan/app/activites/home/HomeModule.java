package com.padowan.app.activites.home;

import android.app.Activity;

import com.padowan.app.activites.home.presenter.HomePresenter;
import com.padowan.app.activites.home.presenter.HomePresenterImpl;
import com.padowan.app.base.PerActivity;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractor;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.padowan.app.model.interactors.home_interactor.HomeInteracotrImpl;
import com.padowan.app.model.interactors.home_interactor.HomeInteractor;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractor;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractorImpl;
import com.padowan.app.model.interactors.team_interactor.TeamInteractor;
import com.padowan.app.model.interactors.team_interactor.TeamInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Korisnik on 22.3.2017..
 */

@Module
public class HomeModule {

    public final HomeView homeView;

     HomeModule(HomeView homeView) {
        this.homeView = homeView;
    }

    @Provides
    @PerActivity
    HomeInteractor provideHomeInteracotr(HomeInteracotrImpl homeInteracotr) {
        return  homeInteracotr;
    }

    @PerActivity
    @Provides
    HomePresenter provideHomePresenter(HomePresenterImpl homePresenter){
        return homePresenter;
    }

    @Provides
    @PerActivity
    HomeView homeView(){
        return this.homeView;
    }

    @Provides
    @PerActivity
    TeamInteractor provideTeamInteracotr(TeamInteractorImpl teamInteractor) {
        return teamInteractor;
    }

    @Provides
    @PerActivity
    CrimeInteractor provideCrimeInteractor(CrimeInteractorImpl crimeInteractor) {
        return crimeInteractor;
    }

    @Provides
    @PerActivity
    PlayerInteractor providePlayerINteractor(PlayerInteractorImpl playerInteractor) {
        return playerInteractor;
    }
}
