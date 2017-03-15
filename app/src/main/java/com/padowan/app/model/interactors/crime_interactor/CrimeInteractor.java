package com.padowan.app.model.interactors.crime_interactor;


import com.padowan.app.base.BaseInteractor;
import com.padowan.app.model.interactors.crime_interactor.listener.BaseCrimeListener;
import com.padowan.app.model.interactors.crime_interactor.listener.CrimeListener;



/**
 * Created by Korisnik on 14.3.2017..
 */

public interface CrimeInteractor extends BaseInteractor{
    void getAllCrimes(CrimeListener crimeListener, String name);
    void getCrimes(BaseCrimeListener crimeListener);
}
