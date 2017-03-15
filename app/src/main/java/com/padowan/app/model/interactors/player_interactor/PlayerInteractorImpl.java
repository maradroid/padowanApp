package com.padowan.app.model.interactors.player_interactor;

import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.interactors.player_interactor.listener.PlayerListener;
import com.padowan.app.utils.RetroUtil;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Korisnik on 14.3.2017..
 */

public class PlayerInteractorImpl implements PlayerInteractor {

    private Call<List<Player>> callPlayer;
    private Call<List<Player>> callPlayerCrimes;

    @Override
    public void getPlayers(final PlayerListener listenerPlayer) {
        callPlayer = RetroUtil.getService().readPlayer();
        callPlayer.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                listenerPlayer.onPlayerSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                listenerPlayer.onDataFailure(t.getMessage());
            }
        });
    }

    @Override
    public void getAllPlayerCrimes(final PlayerListener playerListener, Map<String, String> date) {
        callPlayerCrimes = RetroUtil.getService().readPlayerYearCrimes(date);
        callPlayerCrimes.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                playerListener.onYearPlayerCrime(response.body());
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                playerListener.onDataFailure(t.getMessage());
            }
        });
    }

    @Override
    public void stop() {
        if(callPlayer != null)
            callPlayer.cancel();
        if ( callPlayerCrimes != null)
            callPlayerCrimes.cancel();
    }
}
