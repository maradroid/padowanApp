package com.padowan.app.activites.pager.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padowan.app.R;
import com.padowan.app.activites.list.adapter.RecyclerClickListener;
import com.padowan.app.model.data_model.Player;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Korisnik on 9.3.2017..
 */

public class FragmentRecyclerViewAdapter extends RecyclerView.Adapter<FragmentRecyclerViewAdapter.MyHolderPlayer> {

    //private List<String> playerList = new ArrayList<>();
    private List<Player> playerList = new ArrayList<>();

    @Override
    public FragmentRecyclerViewAdapter.MyHolderPlayer onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.first_fragment, parent, false);

        return new FragmentRecyclerViewAdapter.MyHolderPlayer(view);
    }

    @Override
    public void onBindViewHolder(FragmentRecyclerViewAdapter.MyHolderPlayer holder, int position) {
        holder.tvAllPlayers.setText(playerList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    /*public void setPlayerData(List<String> playerList){
        if(playerList != null && !playerList.isEmpty()){
            this.playerList.clear();
            this.playerList.addAll(playerList);
            notifyDataSetChanged();
        }
    }*/

    public void setPlayerData(List<Player> playerList){
        if(playerList != null && !playerList.isEmpty()){
            this.playerList.clear();
            this.playerList.addAll(playerList);
            notifyDataSetChanged();
        }
    }

    public static class MyHolderPlayer extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_fragment1)
        TextView tvAllPlayers;

        public MyHolderPlayer(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

