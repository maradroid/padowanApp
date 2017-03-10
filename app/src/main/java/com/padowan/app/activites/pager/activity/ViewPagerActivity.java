package com.padowan.app.activites.pager.activity;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import com.padowan.app.R;
import com.padowan.app.activites.pager.InterfaceFragmentActivity;
import com.padowan.app.activites.pager.PlayerYearListener;
import com.padowan.app.activites.pager.adapter.ViewPagerAdapter;
import com.padowan.app.activites.pager.fragment.FirstFragment;
import com.padowan.app.model.data_model.Player;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ViewPagerActivity extends AppCompatActivity implements PlayerYearListener, InterfaceFragmentActivity {

    public static  final String TAG_KEY_PAGER2 = "key2";

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager viewPager;

    private List<Fragment> fragmentList ;
    private ViewPagerAdapter viewPagerAdapter;
    private PagerPresenter pagerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        pagerPresenter = new PagerPresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_pager, menu);
        return true;
    }

    @Override
    public void onSuccessPlayerYearCrime(List<Player> playerYearList, int tag) {
        fragmentList = getSupportFragmentManager().getFragments();

        for (Fragment fragment : fragmentList) {
            FirstFragment firstFragment =  (FirstFragment) fragment;

            if (tag == firstFragment.getPage()) {
                firstFragment.setAdapterData(playerYearList);
                break;
            }
        }
    }
    @Override
    public void sendNameToActivity(String startYear, String endYear, int tag) {
        pagerPresenter.getAllYearCrimes(this, startYear, endYear, tag);
    }

    @Override
    public void onFailure(String error) {

    }

    @Override
    public void onSuccessPlayeYearName(List<String> names, int tag) {

    }

    @Override
    public void sendData(List<String> playerList) {

    }
}
