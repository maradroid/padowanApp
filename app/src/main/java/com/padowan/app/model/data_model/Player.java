package com.padowan.app.model.data_model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Korisnik on 1.3.2017..
 */

public class Player {
    @SerializedName("Name")
    private String name;
    @SerializedName("Team")
    private String team;
    @SerializedName("Team_name")
    private String teamName;
    @SerializedName("Team_city")
    private String teamCity;
    @SerializedName("Position")
    private String position;
    @SerializedName("arrest_count")
    private String arrestCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getArrestCount() {
        return arrestCount;
    }

    public void setArrestCount(String arrestCount) {
        this.arrestCount = arrestCount;
    }
}
