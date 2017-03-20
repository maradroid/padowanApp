package com.padowan.app.activites.rx_subject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.padowan.app.R;
import com.padowan.app.activites.rx_example.presenter.RxExamplePresenterImpl;
import com.padowan.app.activites.rx_subject.presenter.RxSubjectPresenter;
import com.padowan.app.activites.rx_subject.presenter.RxSubjectPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RxSubjectActivity extends AppCompatActivity implements RxSubjectView{

    @BindView(R.id.tv_player_name)
    TextView tvPlayerName;

    private RxSubjectPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_subject);
        ButterKnife.bind(this);
        presenter = new RxSubjectPresenterImpl(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onPlayer(String player) {

    }
}
