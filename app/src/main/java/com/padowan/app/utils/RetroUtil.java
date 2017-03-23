package com.padowan.app.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Korisnik on 23.3.2017..
 */

public class RetroUtil {
/*
    private static final String BASE_URL = "http://nflarrest.com/api/v1/";
    private static WebAPIService service;


    private static void retro() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        service = retrofit.create(WebAPIService.class);
    }

    public static WebAPIService getService() {
        if (service == null) {
            retro();
        }
        return service;
    }*/
}
