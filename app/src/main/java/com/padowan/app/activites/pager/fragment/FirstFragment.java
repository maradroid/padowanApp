package com.padowan.app.activites.pager.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.padowan.app.R;
import com.padowan.app.activites.pager.YearsDelegate;
import com.padowan.app.activites.pager.adapter.FragmentRecyclerViewAdapter;
import com.padowan.app.activites.pager.fragment.presenter.FragmentPresenter;
import com.padowan.app.activites.pager.fragment.presenter.FragmentPresenterImpl;
import com.padowan.app.base.BaseFragment;
import com.padowan.app.model.data_model.Player;

import java.util.List;
import butterknife.BindView;

import static com.padowan.app.activites.pager.fragment.presenter.FragmentPresenterImpl.TAG_PAGE;
import static com.padowan.app.activites.pager.fragment.presenter.FragmentPresenterImpl.TAG_TITLE;


/**
 * Created by Korisnik on 8.3.2017..
 */

public class FirstFragment extends BaseFragment implements FragmentYearView{

    private YearsDelegate yearsDelegate;
    private FragmentRecyclerViewAdapter playerAdapter;
    private FragmentPresenter presenter = new FragmentPresenterImpl(this);

    @BindView(R.id.my_recycler_view_players)
    RecyclerView recyclerViewPlayers;

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
        yearsDelegate = (YearsDelegate) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.setPage(getArguments().getInt(TAG_PAGE, 0));
    }

    public void setAdapterData(List<Player> namesOfPlayers){
        playerAdapter.setPlayerData(namesOfPlayers);
    }

    @Override
    public int getFragmentLayout() {
        return R.layout.first_fragment;
    }

    @Override
    public void someShit() {
        playerAdapter = new FragmentRecyclerViewAdapter();
        recyclerViewPlayers.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewPlayers.setAdapter(playerAdapter);
        presenter.setPageAndTitle();
    }

    public int getPage() {
        return presenter.passThePage();
    }

    @Override
    public void tabSelect(String startDate, String endDate, int tag) {
        yearsDelegate.getDateAndTag(startDate, endDate, tag);
    }
}
