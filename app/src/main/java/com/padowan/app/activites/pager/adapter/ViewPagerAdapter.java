package com.padowan.app.activites.pager.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.padowan.app.activites.pager.fragment.FirstFragment;


/**
 * Created by Korisnik on 8.3.2017..
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public static final int  NUMBER_OF_TABS = 4;

    private String[] tabName  = {"2010","2011", "2012", "2013"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                FirstFragment tab1 = FirstFragment.newInstance(position, tabName[position]);
                return tab1;
            case 1:
                FirstFragment tab2 = FirstFragment.newInstance(position, tabName[position]);
                return tab2;
            case 2:
                FirstFragment tab3 = FirstFragment.newInstance(position, tabName[position]);
                return tab3;
            case 3:
                FirstFragment tab4 = FirstFragment.newInstance(position, tabName[position]);
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUMBER_OF_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabName[position];
    }
}
