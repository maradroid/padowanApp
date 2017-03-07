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
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Team;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerCrimesListenerActivity extends AppCompatActivity implements PlayerCrimesListener, RecyclerClickListener {

    public static  final String TAG_KEY = "key1";

    @BindView(R.id.my_recycler_view)
    RecyclerView mRecyclerView;
    //private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerViewAdapterCrimes crimesAdapter;
    private RecyclerViewAdapterTeams teamsAdapter;
    private String name;
    private RecyclerViewPresenter recyclerViewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_crimes);
        ButterKnife.bind(this);
        name = getIntent().getStringExtra(TAG_KEY);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        if (name.equals("4")) {
            teamsAdapter = new RecyclerViewAdapterTeams();
            teamsAdapter.setListener(this);
            mRecyclerView.setAdapter(teamsAdapter);

        } else if (name.equals("")) {
            crimesAdapter = new RecyclerViewAdapterCrimes();
            crimesAdapter.setListener(this);
            mRecyclerView.setAdapter(crimesAdapter);

        } else{
            mAdapter = new RecyclerViewAdapter();
            mAdapter.setListener(this);
            mRecyclerView.setAdapter(mAdapter);
        }

        recyclerViewPresenter = new RecyclerViewPresenter();

        if (name.equals("4")) {
            recyclerViewPresenter.getAllTeams(this);

        } else if(name.equals("")){
            recyclerViewPresenter.getAllCrimes(this);

        } else{
            recyclerViewPresenter.getPlayerCrimes(this, name);
        }
    }

    @Override
    public void onSuccessCrime(List<ListRecyclerWraper> crimeList) {
        if(crimesAdapter != null) {
            crimesAdapter.setData(crimeList);
        }
    }

    @Override
    public void onSuccessTeam(List<ListRecyclerTeamWraper> teamList) {
        if(teamsAdapter != null){
            teamsAdapter.setData(teamList);
        }
    }

    @Override
    public void onSuccessPlayerCrime(List<Crime> crimeList) {
        if(mAdapter != null) {
            mAdapter.setData(crimeList);
        }
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRecyclerClick(Crime crime) {
        Toast.makeText(this, "Arrest count: " + crime.getArrestCount(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRecyclerClickTeam(Team team) {
        Toast.makeText(this, "Crimes: " + team.getArrestCount(), Toast.LENGTH_SHORT).show();
    }
}

