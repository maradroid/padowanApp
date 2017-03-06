package com.padowan.app.activites.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.padowan.app.R;
import com.padowan.app.activites.list.PlayerCrimesListenerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements HomeListener {

    private static final String TAG = "MainActivity";

    @BindView(R.id.tv_player)
    TextView playerName;
    @BindView(R.id.tv_team)
    TextView teamName;
    @BindView(R.id.tv_crime)
    TextView crimeName;
    @BindView(R.id.button)
    Button button1;
    private boolean playerExe = false;
    private boolean crimeExe = false;
    private boolean teamExe = false;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new Presenter();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopCall();
    }

    @OnClick(R.id.button)
    public void onClick(){
        if (!playerExe && !crimeExe && !teamExe) {
            presenter.getPlayers(this);
            presenter.getCrime(this);
            presenter.getTeam(this);
            playerExe = true;
            crimeExe = true;
            teamExe = true;
        }
    }

    @OnClick(R.id.button2)
    public void OnPlayerCrimes(){
        Intent i = new Intent(this, PlayerCrimesListenerActivity.class);
        i.putExtra(PlayerCrimesListenerActivity.TAG_KEY, playerName.getText().toString());
        startActivity(i);
    }
    @Override
    public void onPlayerResponse(String player) {
        playerName.setText(player);
        playerExe = false;
    }

    @Override
    public void onTeamResponse(String team){
        teamName.setText(team);
        teamExe = false;
    }

    @Override
    public void onCrimeResponse(String crime){
        crimeName.setText(crime);
        crimeExe = false;
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(MainActivity.this,
                "Error!", Toast.LENGTH_LONG).show();
    }
}
