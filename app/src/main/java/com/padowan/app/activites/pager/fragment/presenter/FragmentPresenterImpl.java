package com.padowan.app.activites.pager.fragment.presenter;

import android.app.Fragment;
import android.os.Bundle;

import com.padowan.app.activites.pager.fragment.FragmentYearView;

/**
 * Created by Korisnik on 15.3.2017..
 */

public class FragmentPresenterImpl extends Fragment implements FragmentPresenter{

    private static final String TAG_PAGE = "page";
    private static final String TAG_TITLE = "title";
    public static final int TITLE_2010 = 0;
    public static final int TITLE_2011 = 1;
    public static final int TITLE_2012 = 2;
    public static final int TITLE_2013 = 3;

    private String title;
    private int page = 0;
    private FragmentYearView fragmentYearView;

    public FragmentPresenterImpl(FragmentYearView fragmentYearView) {
        this.fragmentYearView = fragmentYearView;
    }

    public FragmentPresenterImpl() {
    }

    public Bundle setArgs(){
        Bundle args = new Bundle();
        args.putInt(TAG_PAGE, page);
        args.putString(TAG_TITLE, title);
        return args;
    }

    @Override
    public int passThePage() {
        return page;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(TAG_PAGE, 0);
        title = getArguments().getString(TAG_TITLE);
        setPage();
    }

    public void setPage(){
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
}
