package com.padowan.app.activites.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.padowan.app.activites.list.adapter.RecyclerViewAdapter;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapterCrimes;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapterTeams;
import com.padowan.app.activites.list.presenter.ListPresenter;
import com.padowan.app.activites.list.presenter.ListPresenterImpl;
import com.padowan.app.base.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Korisnik on 22.3.2017..
 */
@Module
public class ListModule {

    private ListView listView;

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
    RecyclerView provideRecyclerView (RecyclerView recyclerView){
        return recyclerView;
    }

    @Provides
    @PerActivity
    RecyclerViewAdapter provideRecyclerViewAdapter(RecyclerViewAdapter recyclerViewAdapter){
        return  recyclerViewAdapter;
    }

    @Provides
    @PerActivity
    RecyclerViewAdapterTeams provideRecyclerViewAdapterTeams(RecyclerViewAdapterTeams recyclerViewAdapterTeams){
        return recyclerViewAdapterTeams;
    }

    @Provides
    @PerActivity
    RecyclerViewAdapterCrimes providesRecyclerViewAdapterCrimes(RecyclerViewAdapterCrimes recyclerViewAdapterCrimes){
        return recyclerViewAdapterCrimes;
    }

    @Provides
    @PerActivity
    ListView ListView()
    {
        return this.listView;
    }
}

