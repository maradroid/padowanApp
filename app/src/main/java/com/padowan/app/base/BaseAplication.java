package com.padowan.app.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.test.espresso.DaggerBaseLayerComponent;

import com.padowan.app.utils.ServiceModule;

/**
 * Created by Korisnik on 22.3.2017..
 */

public class BaseAplication extends Application {

    private BaseComponent baseComponent;

    public static BaseAplication get(Activity activity){
        return (BaseAplication) activity.getApplication();
    }

    @Override
    public void onCreate(){
        super.onCreate();
        initAppComponents();
    }

    public static BaseAplication get (Context context){
        return (BaseAplication) context.getApplicationContext();
    }

    public BaseComponent getAppComponent(){
        return baseComponent;
    }

    public void initAppComponents() {
        /*baseComponent = DaggerBaseLayerComponent.builder()
                .baseLayerModule(new ServiceModule())
                .build();*/
    }
}
