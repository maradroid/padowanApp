package com.padowan.app.model.data_model;

/**
 * Created by Korisnik on 2.3.2017..
 */

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("Team")
    private String team;
    @SerializedName("Team_name")
    private String teamName;
    @SerializedName("Team_city")
    private String teamCity;
    @SerializedName("arrest_count")
    private int arrestCount;

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public int getArrestCount() {
        return arrestCount;
    }

    public void setArrestCount(int arrestCount) {
        this.arrestCount = arrestCount;
    }

}