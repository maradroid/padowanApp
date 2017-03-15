package com.padowan.app.model.interactors.crime_interactor;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.interactors.crime_interactor.listener.BaseCrimeListener;
import com.padowan.app.model.interactors.crime_interactor.listener.CrimeListener;
import com.padowan.app.utils.RetroUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Korisnik on 14.3.2017..
 */

public class CrimeInteractorImpl implements CrimeInteractor {

    private Call<List<Crime>> callCrime;
    private Call<List<Crime>> callAllCrimes;

    @Override
    public void getAllCrimes(final CrimeListener crimeListener, String name) {
        callAllCrimes = RetroUtil.getService().readAllCrimes(name);   /**pošalji name iz aktivnosti*/
        callAllCrimes.enqueue(new Callback<List<Crime>>(){
            @Override
            public void onResponse(Call<List<Crime>> call, Response<List<Crime>> response){
                crimeListener.onAllPlayerCrimeSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Crime>> call, Throwable t) {
                crimeListener.onDataFailure(t.getMessage());
            }
        });
    }

    @Override
    public void getCrimes(final BaseCrimeListener crimeListener) {
        callCrime = RetroUtil.getService().readCrime();
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
        if (callCrime != null)
            callCrime.cancel();
        if(callAllCrimes != null)
            callAllCrimes.cancel();
    }
}


