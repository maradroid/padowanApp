package com.padowan.app.activites.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.padowan.app.R;
import com.padowan.app.model.data_model.Player;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements CallLog {

    @Bind(R.id.textView3)
    TextView playerName;
    @Bind(R.id.textView5)
    TextView teamName;
    @Bind(R.id.textView7)
    TextView crimeName;
    @Bind(R.id.button)
    Button button1;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Presenter presenter = new Presenter();

        presenter.getPlayers(this);
        presenter.getCrime(this);
        presenter.getCrime(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onPlayerResponse(String player) {
        playerName.setText(player);
    }

    @Override
    public void onTeamResponse(String team){
        teamName.setText(team);
    }

    @Override
    public void onCrimeResponse(String crime){
        crimeName.setText(crime);
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(MainActivity.this,
                "Error!", Toast.LENGTH_LONG).show();
    }
}
