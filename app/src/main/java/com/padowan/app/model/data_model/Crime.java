package com.padowan.app.model.data_model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Korisnik on 2.3.2017..
 */

public class Crime {

    @SerializedName("Category")
    private String category;
    @SerializedName("arrest_count")
    private int arrestCount;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getArrestCount() {
        return arrestCount;
    }

    public void setArrestCount(int arrestCount) {
        this.arrestCount = arrestCount;
    }

}