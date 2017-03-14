package com.padowan.app.model.interactors.crime_interactor;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.interactors.crime_interactor.listener.CrimeListener;
import com.padowan.app.model.utils.RetroUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Korisnik on 14.3.2017..
 */

public class CrimeInteractorImpl implements CrimeInteractor {

    private Call<List<Crime>> callCrime;

    @Override
    public void getCrimes(final CrimeListener listenerCrime) {
        callCrime = RetroUtil.getService().readCrime();
        callCrime.enqueue(new Callback<List<Crime>>(){
            @Override
            public void onResponse(Call<List<Crime>> call, Response<List<Crime>> response){
                listenerCrime.onCrimeSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Crime>> call, Throwable t) {
                listenerCrime.onDataFailure(t.getMessage());
            }
        });
    }

    @Override
    public void getAllCrimes(final CrimeListener crimeListener) {
        callCrime = RetroUtil.getService().readAllCrimes(name);   /**pošalji name iz aktivnosti*/
        callCrime.enqueue(new Callback<List<Crime>>(){
            @Override
            public void onResponse(Call<List<Crime>> call, Response<List<Crime>> response){
                crimeListener.onCrimeSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Crime>> call, Throwable t) {
                crimeListener.onDataFailure(t.getMessage());
            }
        });
    }

    @Override
    public void stop() {
        callCrime.cancel();
    }
}


