package com.padowan.app.activites.home;

import android.app.Activity;

import com.padowan.app.activites.home.presenter.HomePresenter;
import com.padowan.app.activites.home.presenter.HomePresenterImpl;
import com.padowan.app.base.PerActivity;
import com.padowan.app.model.interactors.home_interactor.HomeInteracotrImpl;
import com.padowan.app.model.interactors.home_interactor.HomeInteractor;

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
}
