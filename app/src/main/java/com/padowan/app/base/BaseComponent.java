package com.padowan.app.base;

import android.app.Application;
import android.support.test.espresso.core.deps.dagger.Component;

import com.padowan.app.activites.home.HomeActivity;
import com.padowan.app.activites.home.HomeModule;
import com.padowan.app.activites.home.HomeSubComponent;
import com.padowan.app.activites.list.ListActivity;
import com.padowan.app.activites.list.ListModule;
import com.padowan.app.activites.list.ListSubComponent;
import com.padowan.app.activites.pager.activity.PagerActivity;
import com.padowan.app.activites.pager.activity.PagerModule;
import com.padowan.app.activites.pager.activity.PagerSubComponent;
import com.padowan.app.utils.ServiceModule;

import javax.inject.Singleton;


/**
 * Created by Korisnik on 21.3.2017..
 */
@Singleton
@Component(modules = ServiceModule.class)
public interface BaseComponent {
    HomeSubComponent plus (HomeModule module);
    ListSubComponent plus (ListModule module);
    PagerSubComponent plus (PagerModule module);

}
