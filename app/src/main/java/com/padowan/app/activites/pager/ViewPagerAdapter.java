package com.padowan.app.activites.pager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Korisnik on 8.3.2017..
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {

            case 0:

                return new FirstFragment();

            case 1:

                return new SecondFragment();

            default:

                return new SecondFragment();

        }
    }

    @Override
    public int getCount() {
        return 0;
    }
}
