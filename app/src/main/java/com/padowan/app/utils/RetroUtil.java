package com.padowan.app.utils;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Mario Bat on 1.3.2017..
 */

/**
 * odvaja se u novi paket jer se koristi u više aktivnosti
 */
@Module
public class RetroUtil {

    private static final String BASE_URL = "http://nflarrest.com/api/v1/";
    private static WebAPIService service;

    @Provides
    private static void retro() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        service = retrofit.create(WebAPIService.class);
    }

    /**
     * ako nije napravljen service, napravi ga u protivnom ga samo vrati
     */
    @Provides
    public static  WebAPIService getService(){
        if(service == null) {
            retro();
        }
        return service;
    }

}
