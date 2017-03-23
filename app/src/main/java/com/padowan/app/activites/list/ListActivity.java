package com.padowan.app.activites.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.padowan.app.R;
import com.padowan.app.activites.list.adapter.ListRecyclerTeamWraper;
import com.padowan.app.activites.list.adapter.ListRecyclerWraper;
import com.padowan.app.activites.list.adapter.RecyclerClickListener;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapter;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapterCrimes;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapterTeams;
import com.padowan.app.activites.list.presenter.ListPresenter;
import com.padowan.app.base.BaseApplication;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.Team;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity implements ListView, RecyclerClickListener {

    public static  final String EXTRA_TO_LIST = "list";

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    RecyclerViewAdapter playerAdapter;
    @Inject
    RecyclerViewAdapterCrimes crimesAdapter;
    @Inject
    RecyclerViewAdapterTeams teamsAdapter;
    @Inject
    ListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_crimes);
        ButterKnife.bind(this);
        BaseApplication.get(this).getAppComponent()
                .plus(new ListModule(this))
                .inject(this);

        presenter.initialize(getIntent().getStringExtra(EXTRA_TO_LIST));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
    }

    @Override
    public void chooseCrimesAdapter() {
        crimesAdapter.setListener(this);
        mRecyclerView.setAdapter(crimesAdapter);
    }

    @Override
    public void chooseTemasAdapter() {
        teamsAdapter.setListener(this);
        mRecyclerView.setAdapter(teamsAdapter);
    }

    @Override
    public void choosePlayerCriemsAdapter() {
        playerAdapter.setListener(this);
        mRecyclerView.setAdapter(playerAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopCall();
    }

    @Override
    public void onRecyclerClick(Crime crime) {
        Toast.makeText(this, "Arrest count: " + crime.getArrestCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRecyclerClickTeam(Team team) {
        Toast.makeText(this, "Crimes: " + team.getArrestCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRecyclerClickPlayer(Player player) {
        return ;
    }

    @Override
    public void onAllCrimes(List<ListRecyclerWraper> crimeList) {
        if(crimesAdapter != null) {
            crimesAdapter.setData(crimeList);
        }
    }

    @Override
    public void onTeamCrimes(List<ListRecyclerTeamWraper> teamList) {
        if(teamsAdapter != null){
            teamsAdapter.setData(teamList);
        }
    }

    @Override
    public void onPlayerCrimes(List<Crime> crimesList) {
        if(playerAdapter != null) {
            playerAdapter.setData(crimesList);
        }
    }

    @Override
    public void showErrorMessage(String error) {
        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
    }
}


