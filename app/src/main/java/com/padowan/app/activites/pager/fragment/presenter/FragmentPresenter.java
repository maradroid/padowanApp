package com.padowan.app.activites.pager.fragment.presenter;

import android.os.Bundle;

/**
 * Created by Korisnik on 15.3.2017..
 */

public interface FragmentPresenter {
    int passThePage();
    void setPageAndTitle();
    void setPage(int page);
}
