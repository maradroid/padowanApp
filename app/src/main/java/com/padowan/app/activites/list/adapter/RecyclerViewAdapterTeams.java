package com.padowan.app.activites.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padowan.app.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Korisnik on 7.3.2017..
 */

public class RecyclerViewAdapterTeams extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ListRecyclerTeamWraper> allTeams = new ArrayList<>();
    private RecyclerClickListener listener;

    @Override
    public int getItemViewType(int position) { return allTeams.get(position).getType();}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        if(viewType == ListRecyclerTeamWraper.TYPE_ORANGE) {
            return new MyHolderOrange(viewItem);

        }else if (viewType == ListRecyclerTeamWraper.TYPE_YELLOW){
            return new MyHolderYellow(viewItem);

        }else if (viewType == ListRecyclerTeamWraper.TYPE_RED){
            return new MyHolderRed(viewItem);

        }else{
            return new MyHolderWhite(viewItem);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int itemType = getItemViewType(position);
        if(itemType == ListRecyclerTeamWraper.TYPE_ORANGE){
            MyHolderOrange myHolderOrange = (MyHolderOrange) holder;
            myHolderOrange.tvListOrangeTeams.setText(allTeams.get(position).getTeamData().getTeamName());

        }else if(itemType == ListRecyclerTeamWraper.TYPE_YELLOW){
            MyHolderYellow myHolderYellow = (MyHolderYellow) holder;
            myHolderYellow.tvListYellowTeams.setText(allTeams.get(position).getTeamData().getTeamName());

        }else if(itemType == ListRecyclerTeamWraper.TYPE_RED){
            MyHolderRed myHolderRed = (MyHolderRed) holder;
            myHolderRed.tvListRedTeams.setText(allTeams.get(position).getTeamData().getTeamName());

        }else{
            MyHolderWhite myHolderWhite = (MyHolderWhite) holder;
            myHolderWhite.tvListWhiteTeams.setText(allTeams.get(position).getTeamData().getTeamName());
        }
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setData(List<ListRecyclerTeamWraper> teamList){
        if(teamList != null && !teamList.isEmpty()){
            this.allTeams.clear();
            this.allTeams.addAll(teamList);
            notifyDataSetChanged();
        }
    }

    private class MyHolderOrange extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_list_orange_teams)
        TextView tvListOrangeTeams;

        MyHolderOrange(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private class MyHolderYellow extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_list_yellow_teams)
        TextView tvListYellowTeams;

        public MyHolderYellow(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private class MyHolderRed extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_list_red_teams)
        TextView tvListRedTeams;

        public MyHolderRed(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private class MyHolderWhite extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_all_crimes)
        TextView tvListWhiteTeams;

        public MyHolderWhite(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setListener(RecyclerClickListener listener) {
        this.listener = listener;
    }
}
