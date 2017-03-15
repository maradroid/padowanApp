package com.padowan.app.activites.pager.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.padowan.app.R;
import com.padowan.app.activites.pager.YearsDelegate;
import com.padowan.app.activites.pager.adapter.FragmentRecyclerViewAdapter;
import com.padowan.app.activites.pager.fragment.presenter.FragmentPresenter;
import com.padowan.app.activites.pager.fragment.presenter.FragmentPresenterImpl;
import com.padowan.app.model.data_model.Player;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Korisnik on 8.3.2017..
 */

public class FirstFragment extends Fragment implements FragmentYearView{

    private Unbinder unbinder;

    YearsDelegate interfaceName;
    private FragmentRecyclerViewAdapter playerAdapter;
    private static FragmentPresenter presenter = new FragmentPresenterImpl();

    @BindView(R.id.my_recycler_view_players)
    RecyclerView recyclerViewPlayers;

    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        fragmentFirst.setArguments(presenter.setArgs());
        return fragmentFirst;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        interfaceName = (YearsDelegate) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       /* page = getArguments().getInt(TAG_PAGE, 0);
        title = getArguments().getString(TAG_TITLE);*/
    }

    public void setAdapterData(List<Player> namesOfPlayers){
        playerAdapter.setPlayerData(namesOfPlayers);
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);

        presenter = new FragmentPresenterImpl(this);
        playerAdapter = new FragmentRecyclerViewAdapter();
        recyclerViewPlayers.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPlayers.setAdapter(playerAdapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public int getPage() {
        return presenter.passThePage();
    }

    @Override
    public void tabSelect(String startDate, String endDate, int tag) {
        interfaceName.getDateAndTag(startDate, endDate, tag);
    }

}
