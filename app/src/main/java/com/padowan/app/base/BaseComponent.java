package com.padowan.app.base;

import com.padowan.app.activites.home.HomeComponent;
import com.padowan.app.activites.home.HomeModule;
import com.padowan.app.activites.list.ListComponent;
import com.padowan.app.activites.list.ListModule;
import com.padowan.app.activites.pager.activity.PagerModule;
import com.padowan.app.activites.pager.activity.PageComponent;
import com.padowan.app.activites.pager.fragment.presenter.FragmentComponent;
import com.padowan.app.activites.pager.fragment.presenter.FragmentModule;
import com.padowan.app.activites.pager.fragment.presenter.FragmentPresenter;
import com.padowan.app.utils.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


/**
 * Created by Korisnik on 21.3.2017..
 */
@Singleton
@Component(modules = ServiceModule.class)
public interface BaseComponent {
    HomeComponent plus (HomeModule module);
    ListComponent plus (ListModule module);
    PageComponent plus (PagerModule module);
    FragmentComponent plus (FragmentModule module);
}
