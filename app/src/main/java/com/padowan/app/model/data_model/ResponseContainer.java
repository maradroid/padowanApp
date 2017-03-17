package com.padowan.app.model.data_model;

import java.util.List;

/**
 * Created by Korisnik on 17.3.2017..
 */

public class ResponseContainer {
    private List<Team> team;
    private List<Crime> crime;
    private List<Player> player;

    public ResponseContainer(List<Team> team, List<Crime> crime, List<Player> player) {
        this.team = team;
        this.crime = crime;
        this.player = player;
    }

    public List<Team> getTeam() {
        return team;
    }

    public List<Crime> getCrime() {
        return crime;
    }

    public List<Player> getPlayer() {
        return player;
    }
}
