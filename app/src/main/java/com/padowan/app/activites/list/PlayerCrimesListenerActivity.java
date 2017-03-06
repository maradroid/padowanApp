package com.padowan.app.activites.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.padowan.app.R;
import com.padowan.app.model.data_model.Crime;

import java.util.List;

public class PlayerCrimesListenerActivity extends AppCompatActivity implements PlayerCrimesListener {

    public static  final String TAG_KEY = "key";

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String name;
    private RecyclerViewPresenter recyclerViewPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_crimes);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerViewPresenter = new RecyclerViewPresenter();

        mRecyclerView.setHasFixedSize(true);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerViewAdapter();
        mRecyclerView.setAdapter(mAdapter);

        name = getIntent().getStringExtra(TAG_KEY);
    }


    @Override
    public void onSuccess(List<Crime> crimeList) {

    }

    @Override
    public void onFail(String error) {

    }
}

