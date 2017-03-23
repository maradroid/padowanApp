package com.padowan.app.activites.pager.activity;

import com.padowan.app.base.PerActivity;

import javax.inject.Inject;

import dagger.Subcomponent;

/**
 * Created by Korisnik on 22.3.2017..
 */

@PerActivity
@Subcomponent (modules = PagerModule.class)
public interface PageComponent {

    void inject (PagerActivity pagerActivity);
}
