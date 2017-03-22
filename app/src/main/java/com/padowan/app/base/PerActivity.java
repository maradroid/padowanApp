package com.padowan.app.base;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Korisnik on 22.3.2017..
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface PerActivity {
}
