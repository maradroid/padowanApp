package com.padowan.app.activites.pager.presenter;

import com.padowan.app.base.BasePresenter;

/**
 * Created by Korisnik on 15.3.2017..
 */

public interface PagerPresenter extends BasePresenter{
    void allYearCrimes(String startDate, String endDate, int page);
}
