package com.padowan.app.activites.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.padowan.app.R;
import com.padowan.app.activites.home.presenter.HomePresenterImpl;
import com.padowan.app.activites.list.ListActivity;
import com.padowan.app.activites.pager.activity.ViewPagerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.padowan.app.R.id.tv_player;

public class HomeActivity extends AppCompatActivity implements HomeView {

    private static final String TAG = "HomeActivity";

    @BindView(tv_player)
    TextView playerName;
    @BindView(R.id.tv_team)
    TextView teamName;
    @BindView(R.id.tv_crime)
    TextView crimeName;

    private boolean playerExe = false;
    private boolean crimeExe = false;
    private boolean teamExe = false;

    private HomePresenterImpl homePresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        homePresenterImpl = new HomePresenterImpl(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        homePresenterImpl.stopCall();
    }

    @OnClick(R.id.button)
    public void onClick(){
        if (!playerExe && !crimeExe && !teamExe) {
            homePresenterImpl.topCrime();
            homePresenterImpl.worstPlayer();
            homePresenterImpl.worstTeam();
            playerExe = true;
            crimeExe = true;
            teamExe = true;
        }
    }

    public void showErrorMessage(String error){
        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button2)
    public void OnPlayerCrimes(){
        if(playerName != null && playerName.getText().length() != 0) {
            Intent i = new Intent(this, ListActivity.class);
            i.putExtra(ListActivity.TAG_KEY, playerName.getText().toString());
            startActivity(i);
        }
    }

    @OnClick(R.id.button3)
    public void OnAllCrimes(){
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra(ListActivity.TAG_KEY, "");
        startActivity(i);
    }

    @OnClick(R.id.button4)
    public void OnAllTeams(){
        Intent i = new Intent(this, ListActivity.class);
        i.putExtra(ListActivity.TAG_KEY, "4");
        startActivity(i);
    }

    @OnClick(R.id.button_fragment)
    public void onOpenFragment(){
        Intent i = new Intent(this, ViewPagerActivity.class);
        i.putExtra( ViewPagerActivity.TAG_KEY_PAGER2, "");
        startActivity(i);
    }

    @Override
    public void onPlayer(String player) {
        playerName.setText(player);
        playerExe = false;
    }

    @Override
    public void onTeam(String team) {
        teamName.setText(team);
        teamExe = false;
    }

    @Override
    public void onCrime(String crime) {
        crimeName.setText(crime);
        crimeExe = false;
    }
}
