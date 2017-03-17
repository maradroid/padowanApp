package com.padowan.app.model.interactors.home_interactor.listener;

import com.padowan.app.base.BaseListener;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.ResponseContainer;
import com.padowan.app.model.data_model.Team;

import java.util.List;

/**
 * Created by Korisnik on 17.3.2017..
 */

public interface HomeListener extends BaseListener{
    void onDataSuccess(ResponseContainer container);
}
