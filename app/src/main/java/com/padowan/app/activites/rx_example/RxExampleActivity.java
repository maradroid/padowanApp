package com.padowan.app.activites.rx_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.padowan.app.R;
import com.padowan.app.activites.list.adapter.RecyclerClickListener;
import com.padowan.app.activites.list.adapter.RecyclerViewAdapter;
import com.padowan.app.activites.rx_example.presenter.RxExamplePresenter;
import com.padowan.app.activites.rx_example.presenter.RxExamplePresenterImpl;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.Team;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RxExampleActivity extends AppCompatActivity implements RxExampleView, RecyclerClickListener {


    @BindView(R.id.my_rx_recycler_view)
    RecyclerView mRecyclerView;

    private RxExamplePresenter presenter;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_example);
        ButterKnife.bind(this);
        presenter = new RxExamplePresenterImpl(this);
        adapter = new RecyclerViewAdapter();
        adapter.setListener(this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

    }

    @Override
    protected void onStop(){
        super.onStop();
        presenter.stopCall();
    }

    @OnClick(R.id.btn_rx_list_of_players)
    public void onPlayersClick(){
        presenter.getCrimes();
    }

    @OnClick(R.id.btn_rx_stop)
    public void onStopClick(){
        presenter.stopClick();
    }

    @Override
    public void showErrorMessage(String error) {
        Log.e("RxActivity", error);
    }

    @Override
    public void onCrime(List<Crime> crime) {
        if(adapter != null) {
            adapter.setData(crime);
        }
    }

    @Override
    public void onCrimes(Crime crime) {
       Log.d("RxActivity", crime.getCategory() );
    }

    @Override
    public void onCrimeNumber(int number) {
        Log.d("RxActivity", String.valueOf(number));
    }

    @Override
    public void onCrimeName(String crime) {
        Log.d("RxActivity", crime);
    }

    @Override
    public void onPlayer(List<Player> playerList) {
        adapter.setDataPlayer(playerList);
    }

    @Override
    public void onRecyclerClick(Crime crime) {
        return ;
    }

    @Override
    public void onRecyclerClickTeam(Team team) {
        return ;
    }
}
