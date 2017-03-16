package com.padowan.app.activites.pager.fragment.presenter;

import android.app.Fragment;

import com.padowan.app.activites.pager.fragment.FragmentYearView;


/**
 * Created by Korisnik on 15.3.2017..
 */

public class FragmentPresenterImpl extends Fragment implements FragmentPresenter{

    public static final String TAG_PAGE = "page";
    public static final String TAG_TITLE = "title";
    public static final int TITLE_2010 = 0;
    public static final int TITLE_2011 = 1;
    public static final int TITLE_2012 = 2;
    public static final int TITLE_2013 = 3;

    private int page = 0;
    private FragmentYearView fragmentYearView;

    public FragmentPresenterImpl(FragmentYearView fragmentYearView) {
        this.fragmentYearView = fragmentYearView;
    }

    @Override
    public int passThePage() {
        return page;
    }

    public void setPageAndTitle(){
        if (page == TITLE_2010){
            fragmentYearView.tabSelect("2010-01-01", "2010-12-31", page);

        }else if (page == TITLE_2011) {
            fragmentYearView.tabSelect("2011-01-01", "2011-12-31", page);

        }else if(page == TITLE_2012) {
            fragmentYearView.tabSelect("2012-01-01", "2012-12-31", page);

        }else if(page == TITLE_2013) {
            fragmentYearView.tabSelect("2013-01-01", "2013-12-31", page);
        }
    }

    @Override
    public void setPage(int page) {
        this.page = page;
    }
}
