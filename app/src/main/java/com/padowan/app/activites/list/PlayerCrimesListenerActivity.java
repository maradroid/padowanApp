package com.padowan.app.activites.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.padowan.app.R;
import com.padowan.app.activites.list.adapter.RecyclerClickListener;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapter;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapterCrimes;
import com.padowan.app.model.data_model.Crime;

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

        if (name != "") {
            mAdapter = new RecyclerViewAdapter();
            mAdapter.setListener(this);
            mRecyclerView.setAdapter(mAdapter);
        }
        else {
            crimesAdapter = new RecyclerViewAdapterCrimes();
            crimesAdapter.setListener(this);
            mRecyclerView.setAdapter(crimesAdapter);
        }

        recyclerViewPresenter = new RecyclerViewPresenter();
        //TODO: rijesi pozive, postaviti uvjete
        recyclerViewPresenter.getPlayerCrimes(this, name);
        recyclerViewPresenter.getAllCrimes(this);

    }


    @Override
    public void onSuccess(List<Crime> crimeList) {
        mAdapter.setData(crimeList);
        //TODO: rijesi adaptere, oba moraju biti pozvana nekim uvjetima
        if(crimesAdapter != null) {
            crimesAdapter.setData(crimeList);
        }
    }

    @Override
    public void onFail(String error) {

    }

    @Override
    public void onRecyclerClick(Crime crime) {
        Toast.makeText(this, "Arrest count: " + crime.getArrestCount(), Toast.LENGTH_SHORT).show();
    }
}

