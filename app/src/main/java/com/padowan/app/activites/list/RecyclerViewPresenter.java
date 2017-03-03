package com.padowan.app.activites.list;

import com.padowan.app.activites.home.CallLog;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.utils.RetroUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Korisnik on 3.3.2017..
 */

public class RecyclerViewPresenter {

    private Call<List<Player>> callPlayerCrimes;

    public void getPlayerCrimes(final CallLog listenerPlayer) {
        callPlayerCrimes = RetroUtil.getService().readAllCrimes();
        callPlayerCrimes.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {

            });

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                listenerPlayer.onFailure(t.getMessage());
            }
        });
    }
}
