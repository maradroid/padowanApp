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
 * Created by Korisnik on 6.3.2017..
 */

public class RecyclerViewAdapterCrimes extends RecyclerView.Adapter<RecyclerViewAdapterCrimes.MyHolder>{

    public static final int ITEM_TYPE = 0;
    public static final int ITEM_HEADER =1;

    private List<Crime> allCrimeList = new ArrayList<>();
    private RecyclerClickListener listener;

    @Override
    public int getItemViewType(int position) {
        if(allCrimeList instanceof MyHolder)
            return ITEM_TYPE;
        else
            return ITEM_HEADER;
    }

    @Override
    public RecyclerViewAdapterCrimes.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == ITEM_TYPE) {
            View viewItem = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.text_view_holder_all_crimes_item, parent, false);

            return new RecyclerViewAdapterCrimes.MyHolder(viewItem);
        }
        else {
            View viewHeader = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.text_view_holder_all_crimes_header, parent, false);
            return new RecyclerViewAdapterCrimes.MyHolder(viewHeader);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterCrimes.MyHolder holder, int position) {
        final int itemType = getItemViewType(position);
        if(itemType == ITEM_TYPE){
            holder.tvListAllCrimes.setText(allCrimeList.get(position).getCategory());
        }
        else{
            char firstLetter = allCrimeList.toString().charAt(0);
            holder.tvListAllCrimes.setText(firstLetter);
        }
    }

    @Override
    public int getItemCount() {
        return allCrimeList.size();
    }

    public void setData(List<Crime> crimeList){
        if(crimeList != null && !crimeList.isEmpty()){
            this.allCrimeList.clear();
            this.allCrimeList.addAll(allCrimeList);
            notifyDataSetChanged();
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_list_all_crimes_item)
        TextView tvListAllCrimes;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
    public void setListener(RecyclerClickListener listener) {
        this.listener = listener;
    }
}

     class MyholderHeader extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_all_crimes_header)
        TextView tvListAllCrimesHeader;

        public MyholderHeader(View itemView) {
            super(itemView);
        }
    }
