package com.padowan.app.activites.home;

import com.padowan.app.base.PerActivity;

import javax.inject.Inject;

import dagger.Subcomponent;

/**
 * Created by Korisnik on 21.3.2017..
 */

@PerActivity
@Subcomponent(modules = HomeModule.class)
public interface HomeComponent {

     void inject(HomeActivity homeActivity);
}
