package com.padowan.app.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Korisnik on 16.3.2017..
 */

public abstract class BaseFragment extends android.support.v4.app.Fragment {

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayout(), container, false);
        unbinder  = ButterKnife.bind(this, view);
        someShit();
        return view;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        unbinder.unbind();
    }

    public abstract int getFragmentLayout();
    public abstract void someShit();

}
