package com.padowan.app.activites.list.presenter;

import com.padowan.app.base.BasePresenter;

/**
 * Created by Korisnik on 14.3.2017..
 */

public interface ListPresenter extends BasePresenter{
    void allTeams();
    void allCrimes();
    void allPlayerCrimes(String name);
    void initialize(String name);
}
