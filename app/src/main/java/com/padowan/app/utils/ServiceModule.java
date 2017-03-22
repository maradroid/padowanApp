package com.padowan.app.utils;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Korisnik on 22.3.2017..
 */

@Module
public class ServiceModule {

    private static final String BASE_URL = "http://nflarrest.com/api/v1/";

    @Singleton
    @Provides
    public  WebAPIService getService(Retrofit retrofit){
        return retrofit.create(WebAPIService.class);
    }

    @Singleton
    @Provides
    public Retrofit retro() {
        return  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
}
