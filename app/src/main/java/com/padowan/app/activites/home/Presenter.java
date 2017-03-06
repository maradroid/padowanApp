package com.padowan.app.activites.home;

import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.utils.RetroUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by Mario Bat on 1.3.2017..
 */
public class Presenter {

    private Call<List<Player>> callPlayer;
    private Call<List<Crime>> callCrime;
    private Call<List<Team>> callTeam;
    //private String player;

    public void stopCall(){
        if(callPlayer != null)
            callPlayer.cancel();
        if(callCrime != null)
            callCrime.cancel();
        if(callTeam != null)
            callTeam.cancel();
    }

    //prosljeđeni interface mora biti final jer mu se pristupa iz anonimne klase

    public void getPlayers(final HomeListener listenerPlayer) {
        callPlayer = RetroUtil.getService().readPlayer();
        callPlayer.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                List<Player> responsePlayerList = response.body();
                //listener.onPlayerResponse(responseList);
                Player worstPlayer = responsePlayerList.get(0);

                for (Player tempPlayer : responsePlayerList) {
                    if (worstPlayer.getArrestCount() < tempPlayer.getArrestCount()) {
                        worstPlayer = tempPlayer;
                    }
                }
                listenerPlayer.onPlayerResponse(worstPlayer.getName());
                //player = worstPlayer.getName();
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                listenerPlayer.onFailure(t.getMessage());
            }
        });
    }

    public void getCrime (final HomeListener listenerCrime) {
        callCrime = RetroUtil.getService().readCrime();
        callCrime.enqueue(new Callback<List<Crime>>() {
            @Override
            public void onResponse(Call<List<Crime>> call, Response<List<Crime>> response) {
                List<Crime>  responseCrimeList = response.body();

               /* Collections.sort(responseCrimeList, new Comparator<Crime>() {
                    @Override
                    public int compare(Crime o1, Crime o2) {
                        return Integer.valueOf(o1.getArrestCount()).compareTo(o2.getArrestCount());
                    }

                });
                listenerCrime.onCrimeResponse(responseCrimeList.get(0).getCategory());*/

                Crime crimes = responseCrimeList.get(0);

                for (Crime tempCrime : responseCrimeList) {
                    if (crimes.getArrestCount() < tempCrime.getArrestCount()) {
                        crimes = tempCrime;
                    }
                }
                listenerCrime.onCrimeResponse(crimes.getCategory());
            }

            @Override
            public void onFailure(Call<List<Crime>> call, Throwable t) {
                listenerCrime.onFailure(t.getMessage());
            }
        });
    }

    public void getTeam(final HomeListener listenerTeam) {
        callTeam = RetroUtil.getService().readTeam();
        callTeam.enqueue(new Callback<List<Team>>() {
            @Override
            public void onResponse(Call<List<Team>> call, Response<List<Team>> response) {
                List<Team> responseTeamList = response.body();

                Team worstTeam = responseTeamList.get(0);

                for (Team tempTeam : responseTeamList) {
                    if (worstTeam.getArrestCount() < tempTeam.getArrestCount()) {
                         worstTeam = tempTeam;
                    }
                }

                listenerTeam.onTeamResponse(worstTeam.getTeam());
            }

            @Override
            public void onFailure(Call<List<Team>> call, Throwable t) {
                listenerTeam.onFailure(t.getMessage());
            }
        });
    }

}
