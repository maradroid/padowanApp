package com.padowan.app.activites.pager.fragment.presenter;

import com.padowan.app.activites.pager.fragment.FirstFragment;
import com.padowan.app.base.PerActivity;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by Korisnik on 23.3.2017..
 */

@PerActivity
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(FirstFragment fragment);
}
