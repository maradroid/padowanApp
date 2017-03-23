package com.padowan.app.activites.pager.fragment.presenter;

import com.padowan.app.activites.pager.adapter.FragmentRecyclerViewAdapter;
import com.padowan.app.activites.pager.fragment.FragmentYearView;
import com.padowan.app.base.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Korisnik on 23.3.2017..
 */

@Module
public class FragmentModule {
    public final FragmentYearView view;

    public FragmentModule(FragmentYearView view) {
        this.view = view;
    }

    @Provides
    @PerActivity
    FragmentYearView fragmentYearView(){
        return this.view;
    }

    @Provides
    @PerActivity
    FragmentPresenter provideFragmentPresenter(FragmentPresenterImpl fragmentPresenter){
        return fragmentPresenter;
    }

    @Provides
    @PerActivity
    FragmentRecyclerViewAdapter provideFragmentAdapter(){
        return new FragmentRecyclerViewAdapter();
    }
}
