package com.padowan.app.activites.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.padowan.app.R;
import com.padowan.app.activites.home.presenter.HomePresenter;
import com.padowan.app.activites.home.presenter.HomePresenterImpl;
import com.padowan.app.activites.list.ListActivity;
import com.padowan.app.activites.pager.activity.PagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.padowan.app.R.id.tv_player;
import static com.padowan.app.activites.list.presenter.ListPresenterImpl.ALL_CRIMES_CONST;
import static com.padowan.app.activites.list.presenter.ListPresenterImpl.ALL_TEAMS_CONST;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @BindView(tv_player)
    TextView playerName;
    @BindView(R.id.tv_team)
    TextView teamName;
    @BindView(R.id.tv_crime)
    TextView crimeName;

    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new HomePresenterImpl(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopCall();
    }

    @OnClick(R.id.btn_show_data)
    public void onClick(){
        presenter.onClickCall();
    }

    public void showErrorMessage(String error){
        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_all_player_crimes)
    public void OnPlayerCrimes(){
        if(playerName != null && playerName.getText().length() != 0) {
            Intent i = new Intent(this, ListActivity.class);
            i.putExtra(ListActivity.EXTRA_TO_LIST, playerName.getText().toString());
            startActivity(i);
        }
    }

    @OnClick(R.id.btn_show_all_crimes)
    public void OnAllCrimes(){
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra(ListActivity.EXTRA_TO_LIST, ALL_CRIMES_CONST);
        startActivity(i);
    }

    @OnClick(R.id.btn_show_all_teams)
    public void OnAllTeams(){
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra(ListActivity.EXTRA_TO_LIST, ALL_TEAMS_CONST);
        startActivity(i);
    }

    @OnClick(R.id.button_fragment)
    public void onOpenFragment(){
        Intent i = new Intent(this, PagerActivity.class);
        i.putExtra( PagerActivity.EXTRA_TO_PAGER, ALL_CRIMES_CONST);
        startActivity(i);
    }

    @Override
    public void onPlayer(String player) {
        playerName.setText(player);
    }

    @Override
    public void onTeam(String team) {
        teamName.setText(team);
    }

    @Override
    public void onCrime(String crime) {
        crimeName.setText(crime);
    }
}
