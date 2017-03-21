package com.padowan.app.activites.rx_subject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.padowan.app.R;
import com.padowan.app.activites.rx_example.RxListActivity;
import com.padowan.app.activites.rx_subject.presenter.RxHomePresenter;
import com.padowan.app.activites.rx_subject.presenter.RxHomePresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RxHomeActivity extends AppCompatActivity implements RxHomeView {

    @BindView(R.id.tv_player_name)
    TextView tvPlayerName;

    private RxHomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_subject);
        ButterKnife.bind(this);
        presenter = new RxHomePresenterImpl(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribeSubscription();
    }

    @Override
    public void onPlayer(String player) {
        tvPlayerName.setText(player);
    }

    @OnClick(R.id.btn_show_player_names)
    public void onPlayerShow(){
            Intent i = new Intent(this, RxListActivity.class);
            i.putExtra(RxListActivity.EXTRA_TO_RX_EXAMPLE,"");
            startActivity(i);
    }
}
