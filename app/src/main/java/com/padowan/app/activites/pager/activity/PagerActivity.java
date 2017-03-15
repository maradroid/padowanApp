package com.padowan.app.activites.pager.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.padowan.app.R;
import com.padowan.app.activites.pager.YearsDelegate;
import com.padowan.app.activites.pager.adapter.ViewPagerAdapter;
import com.padowan.app.activites.pager.fragment.FirstFragment;
import com.padowan.app.activites.pager.presenter.PagerPresenterImpl;
import com.padowan.app.model.data_model.Player;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class PagerActivity extends AppCompatActivity implements PagerView, YearsDelegate {

    public static  final String EXTRA_TO_PAGER = "pager";

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager viewPager;

    private List<Fragment> fragmentList ;
    private ViewPagerAdapter viewPagerAdapter;
    private PagerPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        presenter = new PagerPresenterImpl(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopCall();
    }

    @Override
    public void getDateAndTag(String startYear, String endYear, int tag) {
        presenter.allYearCrimes(startYear, endYear, tag);
    }

    @Override
    public void onYearlyPlayerCrime(List<Player> playerYearCrime, int page) {
        fragmentList = getSupportFragmentManager().getFragments();

        for (Fragment fragment : fragmentList) {
            FirstFragment firstFragment =  (FirstFragment) fragment;

            if (page == firstFragment.getPage()) {
                firstFragment.setAdapterData(playerYearCrime);
                break;
            }
        }
    }

    @Override
    public void showErrorMessage(String error) {
        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
    }
}
