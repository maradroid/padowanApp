package com.padowan.app.base;

import android.support.test.espresso.core.deps.dagger.Component;

import com.padowan.app.utils.RetroUtil;

import javax.inject.Singleton;

/**
 * Created by Korisnik on 21.3.2017..
 */
@Singleton
@Component (modules = RetroUtil.class)
public interface BaseComponent {
    RetroUtil retro();
}
