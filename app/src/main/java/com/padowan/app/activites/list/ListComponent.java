package com.padowan.app.activites.list;

import com.padowan.app.base.PerActivity;

import javax.inject.Inject;

import dagger.Subcomponent;

/**
 * Created by Korisnik on 22.3.2017..
 */
@PerActivity
@Subcomponent(modules = ListModule.class)
public interface ListComponent {

    void inject(ListActivity listActivity);
}
