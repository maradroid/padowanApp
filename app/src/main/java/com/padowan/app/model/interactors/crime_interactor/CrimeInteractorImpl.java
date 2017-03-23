package com.padowan.app.model.interactors.crime_interactor;

import com.padowan.app.base.BaseApplication;
import com.padowan.app.base.BaseInteractor;
import com.padowan.app.base.BaseInteractorImpl;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.interactors.crime_interactor.listener.BaseCrimeListener;
import com.padowan.app.model.interactors.crime_interactor.listener.CrimeListener;
import com.padowan.app.utils.RetroUtil;
import com.padowan.app.utils.ServiceModule;
import com.padowan.app.utils.WebAPIService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Korisnik on 14.3.2017..
 */

public class CrimeInteractorImpl extends BaseInteractorImpl implements CrimeInteractor {

    @Inject
    WebAPIService webAPIService;

    @Inject
    public CrimeInteractorImpl() {
    }

    @Override
    public void getAllCrimes(final CrimeListener crimeListener, String name) {
        addSubscription(getAllCrimesObservable(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Crime>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        stop();
                        crimeListener.onDataFailure("Error!");
                    }

                    @Override
                    public void onNext(List<Crime> crimes) {
                        crimeListener.onAllPlayerCrimeSuccess(crimes);
                    }
                }));
    }

    @Override
    public void getCrimes(final BaseCrimeListener crimeListener) {
        addSubscription(getCrimesObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Crime>>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public final void onError(Throwable t) {
                        stop();
                        crimeListener.onDataFailure("Error!");
                    }

                    @Override
                    public final void onNext(List<Crime> response) {
                        crimeListener.onCrimeSuccess(response);
                    }
                }));
    }

    @Override
    public Observable<List<Crime>> getCrimesObservable() {

        return webAPIService.readCrime();
    }

    @Override
    public Observable<List<Crime>> getAllCrimesObservable(String name) {
        return webAPIService.readAllCrimes(name);
    }

    @Override
    public void stop() {
        unsubscribeSubscription();
    }
}
