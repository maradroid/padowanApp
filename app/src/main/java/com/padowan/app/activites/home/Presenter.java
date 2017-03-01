package com.padowan.app.activites.home;

import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.utils.RetroUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mario Bat on 1.3.2017..
 */
public class Presenter {
    //prosljeđeni interface mora biti final jer mu se pristupa iz anonimne klase
    public void getPlayers(final CallLog listener){
        Call<List<Player>> call = RetroUtil.getService().readPlayer();
        call.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                List<Player> responseList = response.body();
                //listener.onPlayerResponse(responseList);
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }
}
