package com.padowan.app.model.interactors.crime_interactor;


import com.padowan.app.model.interactors.crime_interactor.listener.CrimeListener;



/**
 * Created by Korisnik on 14.3.2017..
 */

public interface CrimeInteractor extends CrimeListener{
    void getAllCrimes(CrimeListener crimeListener, String name);
    void getCrimes(CrimeListener crimeListener);
}
