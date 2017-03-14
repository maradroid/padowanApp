package com.padowan.app.model.interactors.crime_interactor;


import com.padowan.app.model.interactors.crime_interactor.listener.CrimeListener;



/**
 * Created by Korisnik on 14.3.2017..
 */

public interface CrimeInteractor {
    void getCrimes(final CrimeListener listenerCrime);
    void getAllCrimes(CrimeListener crimeListener);
    void stop();
}
