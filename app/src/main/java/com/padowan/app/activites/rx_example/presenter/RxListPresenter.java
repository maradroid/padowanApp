package com.padowan.app.activites.rx_example.presenter;

import com.padowan.app.base.BasePresenter;

/**
 * Created by Korisnik on 20.3.2017..
 */

public interface RxListPresenter extends BasePresenter{
    void getCrimes();
    void getPlayers();
    void stopClick();
}
