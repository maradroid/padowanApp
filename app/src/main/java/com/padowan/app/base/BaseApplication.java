package com.padowan.app.base;

import android.app.Application;
import android.content.Context;

import com.padowan.app.utils.ServiceModule;

/**
 * Created by Korisnik on 22.3.2017..
 */

public class BaseApplication extends Application {

    private BaseComponent baseComponent;
    private ServiceModule serviceModule;

    @Override
    public void onCreate(){
        super.onCreate();
        initAppComponents();
    }

    public static BaseApplication get (Context context){
        return (BaseApplication) context.getApplicationContext();
    }

    public BaseComponent getAppComponent(){
        return baseComponent;
    }

    public void initAppComponents() {
        baseComponent = DaggerBaseComponent.builder()
                .serviceModule(new ServiceModule())
                .build();
    }

    public  ServiceModule getService(){
        return serviceModule;
    }
}
