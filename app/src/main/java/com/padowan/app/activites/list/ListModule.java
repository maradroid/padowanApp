package com.padowan.app.activites.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.padowan.app.activites.list.adapter.RecyclerViewAdapter;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapterCrimes;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapterTeams;
import com.padowan.app.activites.list.presenter.ListPresenter;
import com.padowan.app.activites.list.presenter.ListPresenterImpl;
import com.padowan.app.base.PerActivity;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractor;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.padowan.app.model.interactors.team_interactor.TeamInteractor;
import com.padowan.app.model.interactors.team_interactor.TeamInteractorImpl;
import com.padowan.app.utils.ServiceModule;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Korisnik on 22.3.2017..
 */
@Module
public class ListModule {

    public final ListView listView;

    public ListModule(ListView listView) {
        this.listView = listView;
    }

    @Provides
    @PerActivity
    ListPresenter provideListPresenter(ListPresenterImpl listPresenter) {
        return listPresenter;
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
    RecyclerViewAdapter provideRecyclerViewAdapter(){
        return new RecyclerViewAdapter();
    }

    @Provides
    @PerActivity
    RecyclerViewAdapterTeams provideRecyclerViewAdapterTeams(){
        return new RecyclerViewAdapterTeams();
    }

    @Provides
    @PerActivity
    RecyclerViewAdapterCrimes providesRecyclerViewAdapterCrimes(){
        return new RecyclerViewAdapterCrimes();
    }

    @Provides
    @PerActivity
    ListView ListView()
    {
        return this.listView;
    }
}

