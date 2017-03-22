package com.padowan.app.activites.pager.activity;

import com.padowan.app.activites.pager.presenter.PagerPresenter;
import com.padowan.app.activites.pager.presenter.PagerPresenterImpl;
import com.padowan.app.base.PerActivity;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractor;
import com.padowan.app.model.interactors.player_interactor.PlayerInteractorImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Korisnik on 22.3.2017..
 */

@Module
public class PagerModule {
    public final PagerView pagerView;

    public PagerModule(PagerView pagerView) {
        this.pagerView = pagerView;
    }

    @Provides
    @PerActivity
    PagerView pagerView() {
        return this.pagerView;
    }

    @Provides
    @PerActivity
    PlayerInteractor providePlayerInteractor(PlayerInteractorImpl playerInteractor){
    return playerInteractor;
    }

    @Provides
    @PerActivity
    PagerPresenter providePagerPresenter(PagerPresenterImpl pagerPresenter){
        return pagerPresenter;
    }
}
