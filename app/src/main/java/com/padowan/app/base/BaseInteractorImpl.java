package com.padowan.app.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by Korisnik on 17.3.2017..
 */

public class BaseInteractorImpl {
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    protected void addSubscription( Subscription subscription){
        if(compositeSubscription == null || compositeSubscription.isUnsubscribed()) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }
    protected void unsubscribeSubscription(){
        compositeSubscription.unsubscribe();
    }
}
