package com.padowan.app.activites.pager.activity;

import com.padowan.app.activites.pager.PlayerYearListener;
import com.padowan.app.model.data_model.Player;
import com.padowan.app.model.utils.RetroUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Korisnik on 9.3.2017..
 */

public class PagerPresenter {

    private Call<List<Player>> callAllYearCrimes;

    private Map<String, String> getUrl(String startDate, String endDate){

        Map<String, String> urlMap = new HashMap<>();

        urlMap.put("start_date", startDate);
        urlMap.put("end_date", endDate);

        return urlMap;
    }

    public void getAllYearCrimes(final PlayerYearListener listener, String startDate, String endDate){
        callAllYearCrimes = RetroUtil.getService().readPlayerYearCrimes(getUrl(startDate, endDate));
        callAllYearCrimes.enqueue(new Callback<List<Player>>() {
            @Override
            public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {

                /*List<String> nameList = new ArrayList<String>();
                String name = "";
                for(Player player : response.body()){
                    name += player.getName();
                nameList.add(name);}*/

                listener.onSuccessPlayerYearCrime(response.body());
                //listener.onSuccessPlayeYearName(nameList);
            }

            @Override
            public void onFailure(Call<List<Player>> call, Throwable t) {
                listener.onFailure(t.getMessage());
            }
        });

    }
}
