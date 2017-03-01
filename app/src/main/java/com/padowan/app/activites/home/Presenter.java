package com.padowan.app.activites.home;

import com.padowan.app.utils.RetroUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mario Bat on 1.3.2017..
 */
public class Presenter {
    //prosljeđeni interface mora biti final jer mu se pristupa iz anonimne klase
    public void getPlayers(final CallLog listener){
        Call<String> call = RetroUtil.getService().readPlayer();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });
    }
}
