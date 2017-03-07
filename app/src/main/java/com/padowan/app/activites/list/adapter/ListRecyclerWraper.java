package com.padowan.app.activites.list.adapter;

import com.google.gson.annotations.SerializedName;
import com.padowan.app.R;
import com.padowan.app.model.data_model.Crime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Korisnik on 7.3.2017..
 */

public class ListRecyclerWraper {

    public static final int TYPE_ITEM = R.layout.text_view_holder_all_crimes_item;
    public static final int TYPE_HEADER = R.layout.text_view_holder_all_crimes_header;

    private String headerData;
    private Crime itemData;
    private int type;

    public ListRecyclerWraper(String headerData, int type) {
        this.headerData = headerData;
        this.type = type;
        Object object = new Object();
    }

    public ListRecyclerWraper(Crime itemData, int type) {
        this.itemData = itemData;
        this.type = type;
    }

    public String getHeaderData() {
        return headerData;
    }

    public void setHeaderData(String headerData) {
        this.headerData = headerData;
    }

    public Crime getItemData() {
        return itemData;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setItemData(Crime itemData) {
        this.itemData = itemData;

    }
}
