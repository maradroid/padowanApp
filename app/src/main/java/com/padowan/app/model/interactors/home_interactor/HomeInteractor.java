package com.padowan.app.model.interactors.home_interactor;

import com.padowan.app.base.BaseInteractor;
import com.padowan.app.model.interactors.home_interactor.listener.HomeListener;

import java.util.List;

/**
 * Created by Korisnik on 17.3.2017..
 */

public interface HomeInteractor extends BaseInteractor{
    void getData(HomeListener homeListener);
}
