package com.padowan.app.activites.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.padowan.app.R;

public class MainActivity extends AppCompatActivity implements CallLog {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Presenter presenter = new Presenter();
        presenter.getPlayers(this);
    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG, response);
    }

    @Override
    public void onFailure(String error) {
        Log.e(TAG, error);
    }
}
