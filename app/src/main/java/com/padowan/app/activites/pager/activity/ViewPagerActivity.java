package com.padowan.app.activites.pager.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.padowan.app.R;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapter;
import com.padowan.app.activites.pager.InterfaceFragmentActivity;
import com.padowan.app.activites.pager.PlayerYearListener;
import com.padowan.app.activites.pager.adapter.FragmentRecyclerViewAdapter;
import com.padowan.app.activites.pager.adapter.ViewPagerAdapter;
import com.padowan.app.activites.pager.fragment.FirstFragment;
import com.padowan.app.activites.pager.fragment.FragmentA;
import com.padowan.app.model.data_model.Player;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewPagerActivity extends AppCompatActivity implements PlayerYearListener, InterfaceFragmentActivity {

    public static  final String TAG_KEY_PAGER2 = "key2";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager viewPager;

    private FirstFragment fragment;
    private ViewPagerAdapter viewPagerAdapter;
    private PagerPresenter pagerPresenter;
    //private FragmentRecyclerViewAdapter playerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        ButterKnife.bind(this);

        tabLayout.addTab(tabLayout.newTab().setText("2010"));
        tabLayout.addTab(tabLayout.newTab().setText("2011"));
        tabLayout.addTab(tabLayout.newTab().setText("2012"));
        tabLayout.addTab(tabLayout.newTab().setText("2013"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        fragment = new FirstFragment();
        //playerAdapter = new FragmentRecyclerViewAdapter();
        pagerPresenter = new PagerPresenter();

    }

    public void sendDataToActivity(String startDate, String endDate){
        pagerPresenter.getAllYearCrimes(this, startDate, endDate);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_pager, menu);
        return true;
    }

    @Override
    public void onSuccessPlayerYearCrime(List<Player> playerYearList) {
        fragment.getNamesOfPlayers(playerYearList);
    }

    @Override
    public void onFailure(String error) {

    }

    @Override
    public void onSuccessPlayeYearName(List<String> names) {
       // playerAdapter.setPlayerData(names);
    }

    @Override
    public void sendData(List<String> playerList) {
        //playerAdapter.setPlayerData(playerList);
       // fragment.getNamesOfPlayers(playerList);
    }

    @Override
    public void sendNameToActivity(String startYear, String endYear) {
        pagerPresenter.getAllYearCrimes(this, startYear, endYear);
    }
}
