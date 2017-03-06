package com.padowan.app.activites.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padowan.app.R;
import com.padowan.app.model.data_model.Crime;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Korisnik on 3.3.2017..
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private List<Crime> crimeList = new ArrayList<>();
    private RecyclerClickListener listener;

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_view_holder_crimes, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tvAllCrimes.setText(crimeList.get(position).getCategory());
    }

    @Override
    public int getItemCount() {
        return crimeList.size();
    }

    public void setData(List<Crime> crimeList){
        if(crimeList != null && !crimeList.isEmpty()){
            this.crimeList.clear();
            this.crimeList.addAll(crimeList);
            notifyDataSetChanged();
        }
    }

    class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.tv_all_crimes)
        TextView tvAllCrimes;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onRecyclerClick(crimeList.get(getAdapterPosition()));
            }
        }
    }

    public void setListener(RecyclerClickListener listener) {
        this.listener = listener;
    }
}
