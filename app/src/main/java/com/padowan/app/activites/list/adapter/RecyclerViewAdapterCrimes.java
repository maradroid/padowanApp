package com.padowan.app.activites.list.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.padowan.app.R;
import com.padowan.app.model.data_model.Crime;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Korisnik on 6.3.2017..
 */

public class RecyclerViewAdapterCrimes extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<ListRecyclerWraper> allCrimeList = new ArrayList<>();
    private RecyclerClickListener listener;

    @Override
    public int getItemViewType(int position) {
        return allCrimeList.get(position).getType();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        if(viewType == ListRecyclerWraper.TYPE_ITEM) {
            return new MyHolder(viewItem);

        } else {
            return new MyHolderHeader(viewItem);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int itemType = getItemViewType(position);
        if(itemType == ListRecyclerWraper.TYPE_ITEM){
            MyHolder myHolder = (MyHolder) holder;
            myHolder.tvListAllCrimesItem.setText(allCrimeList.get(position).getItemData().getCategory());

        } else{
            MyHolderHeader myHolder = (MyHolderHeader) holder;
            myHolder.tvListAllCrimesHeader.setText(allCrimeList.get(position).getHeaderData());
        }
    }

    @Override
    public int getItemCount() {
        return allCrimeList.size();
    }

    public void setData(List<ListRecyclerWraper> crimeList){
        if(crimeList != null && !crimeList.isEmpty()){
            this.allCrimeList.clear();
            this.allCrimeList.addAll(crimeList);
            notifyDataSetChanged();
        }
    }

     class MyHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_list_all_crimes_item)
        TextView tvListAllCrimesItem;

         @BindView(R.id.vw_button)
         View viewDelete;

         @OnClick(R.id.vw_button)
         void onClick(){
             getAdapterPosition();

             if(allCrimeList.get(getAdapterPosition()).getType() != allCrimeList.get(getAdapterPosition() + 1).getType()
                     && allCrimeList.get(getAdapterPosition()).getType() != allCrimeList.get(getAdapterPosition() - 1).getType()){
                 removeAt(getAdapterPosition() - 1);
             }
             removeAt(getAdapterPosition());
         }

    MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    class MyHolderHeader extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_all_crimes_header)
        TextView tvListAllCrimesHeader;

        MyHolderHeader(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public void setListener(RecyclerClickListener listener) {
        this.listener = listener;
    }

    private void removeAt(int position) {
        allCrimeList.remove(position);
        notifyItemRemoved(position);
    }

}


