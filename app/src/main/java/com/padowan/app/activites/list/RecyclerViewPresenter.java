package com.padowan.app.activites.list;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.utils.RetroUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Korisnik on 3.3.2017..
 */

public class RecyclerViewPresenter {

    private Call<List<Crime>> callPlayerCrimes;
    private  Call<List<Crime>> callAllPlayerCrimes;

    public void getPlayerCrimes(final PlayerCrimesListener listener, String name) {
        callPlayerCrimes = RetroUtil.getService().readAllCrimes(name);
        callPlayerCrimes.enqueue(new Callback<List<Crime>>() {
            @Override
            public void onResponse(Call<List<Crime>> call, Response<List<Crime>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Crime>> call, Throwable t) {
                listener.onFail(t.getMessage());
            }
        });
    }

    public void getAllCrimes(final PlayerCrimesListener listener) {
        callAllPlayerCrimes = RetroUtil.getService().readCrime();
        callAllPlayerCrimes.enqueue(new Callback<List<Crime>>() {
            @Override
            public void onResponse(Call<List<Crime>> call, Response<List<Crime>> response) {
                List<Crime>  responseCrimeList = response.body();

                Collections.sort(responseCrimeList, new Comparator<Crime>() {
                    @Override
                    public int compare(Crime o1, Crime o2) {
                        return o1.getCategory().compareTo(o2.getCategory());
                    }

                });
                listener.onSuccess(responseCrimeList);
            }

            @Override
            public void onFailure(Call<List<Crime>> call, Throwable t) {
                listener.onFail(t.getMessage());
            }
        });
    }
}
