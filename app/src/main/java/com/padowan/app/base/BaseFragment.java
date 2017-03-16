package com.padowan.app.base;

import android.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Korisnik on 16.3.2017..
 */

public class BaseFragment extends Fragment {

    private Unbinder unbinder;

    public void getButterKnife(View view){
        unbinder = ButterKnife.bind(this, view);
    }

    public void destroy() {
        unbinder.unbind();
    }

}
