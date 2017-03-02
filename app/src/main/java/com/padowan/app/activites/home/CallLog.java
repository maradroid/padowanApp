package com.padowan.app.activites.home;

import com.padowan.app.model.data_model.Player;

import java.util.List;

/**
 * Created by Mario Bat on 1.3.2017..
 */

public interface CallLog {
    void onPlayerResponse(String player);
    void onTeamResponse (String Team);
    void onCrimeResponse (String Crime);
    void onFailure(String error);
}
