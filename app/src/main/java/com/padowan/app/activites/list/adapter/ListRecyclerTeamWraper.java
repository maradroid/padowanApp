package com.padowan.app.activites.list.adapter;

import com.padowan.app.R;
import com.padowan.app.model.data_model.Team;

/**
 * Created by Korisnik on 7.3.2017..
 */

class ListRecyclerTeamWraper {
    public static final int TYPE_YELLOW = R.layout.text_view_yellow_teams;
    public static final int TYPE_ORANGE = R.layout.text_view_orange_teams;
    public static final int TYPE_RED = R.layout.text_view_red_teams;
    public static final int TYPE_WHITE = R.layout.text_view_holder_all_crimes_item;

    private Team teamData;
    private int arrestCount;
    private int type;

    public ListRecyclerTeamWraper(Team teamData, int type) {
        this.teamData = teamData;
        this.type = type;
    }

    public ListRecyclerTeamWraper(int arrestCount, int type) {
        this.arrestCount = arrestCount;
        this.type = type;
    }

    public int getArrestCount() {
        return arrestCount;
    }

    public void setArrestCount(int arrestCount) {
        this.arrestCount = arrestCount;
    }

    public Team getTeamData() {
        return teamData;
    }

    public void setTeamData(Team teamData) {
        this.teamData = teamData;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
