package com.padowan.app.model.interactors.crime_interactor.listener;

import com.padowan.app.base.BaseInteractor;
import com.padowan.app.base.BaseListener;
import com.padowan.app.model.data_model.Crime;

import java.util.List;

/**
 * Created by Korisnik on 14.3.2017..
 */

public interface CrimeListener extends BaseListener{
    void onAllPlayerCrimeSuccess(List<Crime> crimes);
    void onCrimeSuccess (List<Crime> crime);
}
