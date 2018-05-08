package com.example.revern.vkontaktetest.news_feed.models.base;

import com.google.gson.annotations.SerializedName;

public class ViewsInfo {

    @SerializedName("count") private int count;

    public int getCount() {
        return count;
    }

}
