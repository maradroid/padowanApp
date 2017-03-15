package com.padowan.app.activites.list.presenter;

import com.padowan.app.activites.list.ListView;
import com.padowan.app.activites.list.adapter.ListRecyclerTeamWraper;
import com.padowan.app.activites.list.adapter.ListRecyclerWraper;
import com.padowan.app.model.data_model.Crime;
import com.padowan.app.model.data_model.Team;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractor;
import com.padowan.app.model.interactors.crime_interactor.CrimeInteractorImpl;
import com.padowan.app.model.interactors.crime_interactor.listener.CrimeListener;
import com.padowan.app.model.interactors.team_interactor.TeamInteractor;
import com.padowan.app.model.interactors.team_interactor.TeamInteractorImpl;
import com.padowan.app.model.interactors.team_interactor.listener.TeamListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Korisnik on 3.3.2017..
 */

public class ListPresenterImpl implements CrimeListener, TeamListener, ListPresenter{

    public static final String ALL_CRIMES_CONST = "";
    public static final String ALL_TEAMS_CONST = "all teams";

    private TeamInteractor teamInteractor;
    private CrimeInteractor crimeInteractor;
    private ListView listView;

    private List<ListRecyclerWraper> crimeListWraper;

    public ListPresenterImpl(ListView listView) {
        this.listView = listView;
        teamInteractor = new TeamInteractorImpl();
        crimeInteractor = new CrimeInteractorImpl();
    }

    @Override
    public void onTeamSuccess(List<Team> team) {
        if (team != null && !team.isEmpty()) {
            Collections.sort(team, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    return Integer.valueOf(o1.getArrestCount()).compareTo(o2.getArrestCount());
                }
            });

            List<ListRecyclerTeamWraper> recyclerTeamList = new ArrayList<ListRecyclerTeamWraper>();

            for (Team teams : team) {
                if (teams.getArrestCount() <= 10) {
                    recyclerTeamList.add(new ListRecyclerTeamWraper(teams, ListRecyclerTeamWraper.TYPE_WHITE));

                } else if (teams.getArrestCount() > 10 && teams.getArrestCount() <= 20) {
                    recyclerTeamList.add(new ListRecyclerTeamWraper(teams, ListRecyclerTeamWraper.TYPE_YELLOW));

                } else if (teams.getArrestCount() > 20 && teams.getArrestCount() <= 30) {
                    recyclerTeamList.add(new ListRecyclerTeamWraper(teams, ListRecyclerTeamWraper.TYPE_ORANGE));

                } else {
                    recyclerTeamList.add(new ListRecyclerTeamWraper(teams, ListRecyclerTeamWraper.TYPE_RED));
                }
            }
            listView.onTeamCrimes(recyclerTeamList);
        }
    }

    @Override
    public void onCrimeSuccess(List<Crime> allCrimes) {
        if (allCrimes != null && !allCrimes.isEmpty()) {
            Collections.sort(allCrimes, new Comparator<Crime>() {
                @Override
                public int compare(Crime o1, Crime o2) {
                    return o1.getCategory().compareTo(o2.getCategory());
                }
            });
            List<ListRecyclerWraper> recyclerList = new ArrayList<>();
            char firstLetter = '$';
            for (Crime crimes : allCrimes) {
                if (crimes.getCategory().charAt(0) != firstLetter) {
                    firstLetter = crimes.getCategory().charAt(0);
                    recyclerList.add(new ListRecyclerWraper(String.valueOf(firstLetter), ListRecyclerWraper.TYPE_HEADER));
                }
                recyclerList.add(new ListRecyclerWraper(crimes, ListRecyclerWraper.TYPE_ITEM));
            }
            crimeListWraper = recyclerList;
            listView.onAllCrimes(crimeListWraper);
        }
    }

    @Override
    public void onAllPlayerCrimeSuccess(List<Crime> crime) {
        if(crime != null && !crime.isEmpty()){
            listView.onPlayerCrimes(crime);
        }
    }

    @Override
    public void onDataFailure(String error) {
        listView.showErrorMessage(error);
    }

    @Override
    public void allTeams() {
        teamInteractor.getTeams(this);
    }

    @Override
    public void allCrimes() {
        crimeInteractor.getCrimes(this);
    }

    @Override
    public void allPlayerCrimes(String name) {
        crimeInteractor.getAllCrimes(this, name);
    }

    @Override
    public void initialize(String name) {
        if(name.equals(ALL_TEAMS_CONST)){
            listView.chooseTemasAdapter();
            allTeams();
        }else if(name.equals(ALL_CRIMES_CONST)){
            listView.chooseCrimesAdapter();
            allCrimes();
        }else{
            listView.choosePlayerCriemsAdapter();
            allPlayerCrimes(name);
        }
    }

    @Override
    public void stopCall() {
        if (teamInteractor != null)
            teamInteractor.stop();
        if (crimeInteractor != null)
            crimeInteractor.stop();
    }
}

