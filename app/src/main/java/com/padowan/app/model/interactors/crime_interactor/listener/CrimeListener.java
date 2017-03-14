package com.padowan.app.model.interactors.crime_interactor.listener;

import com.padowan.app.base.BaseInteractor;
import com.padowan.app.model.data_model.Crime;

import java.util.List;

/**
 * Created by Korisnik on 14.3.2017..
 */

public interface CrimeListener extends BaseInteractor{
    void onCrimeSuccess (List<Crime> crime);
}
