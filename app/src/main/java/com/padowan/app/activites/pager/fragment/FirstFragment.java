package com.padowan.app.activites.pager.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padowan.app.R;
import com.padowan.app.activites.pager.InterfaceFragmentActivity;
import com.padowan.app.activites.pager.activity.ViewPagerActivity;
import com.padowan.app.activites.pager.adapter.FragmentRecyclerViewAdapter;
import com.padowan.app.activites.pager.adapter.ViewPagerAdapter;
import com.padowan.app.model.data_model.Player;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Korisnik on 8.3.2017..
 */

public class FirstFragment extends Fragment{

    public static final String TAG = "firstFragment";
    private static final String TAG_PAGE = "page";
    private static final String TAG_TITLE = "title";
    public static final int TITLE_2010 = 0;
    public static final int TITLE_2011 = 1;
    public static final int TITLE_2012 = 2;
    public static final int TITLE_2013 = 3;

    private Unbinder unbinder;
    private String title;
    private int page;
    //private List<String> playersNames;
    private List<Player> playersNames;
    InterfaceFragmentActivity interfaceName;
    private FragmentRecyclerViewAdapter playerAdapter;

    @BindView(R.id.tv_fragment1)
    TextView tvFragment1;

    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt(TAG_PAGE, page);
        args.putString(TAG_TITLE, title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceName = (InterfaceFragmentActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playerAdapter = new FragmentRecyclerViewAdapter();

        page = getArguments().getInt(TAG_PAGE, 0);
        title = getArguments().getString(TAG_TITLE);

        if(page == TITLE_2010)
            interfaceName.sendNameToActivity("2010-01-01", "2010-12-31");
        else if (page == TITLE_2011)
            interfaceName.sendNameToActivity("2011-01-01", "2011-12-31");
        else if(page == TITLE_2012)
            interfaceName.sendNameToActivity("2012-01-01", "2012-12-31");
        else if(page == TITLE_2013)
            interfaceName.sendNameToActivity("2013-01-01", "2013-12-31");
    }

   /* public void getNamesOfPlayers(List<String> namesOfPlayers){
        playersNames = namesOfPlayers;
        playerAdapter.setPlayerData(playersNames);
    }*/

    public void getNamesOfPlayers(List<Player> namesOfPlayers){
        playersNames = namesOfPlayers;
        playerAdapter.setPlayerData(playersNames);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
