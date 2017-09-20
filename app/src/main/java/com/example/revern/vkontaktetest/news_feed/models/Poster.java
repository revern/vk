package com.example.revern.vkontaktetest.news_feed.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 20.09.2017.
 */

public abstract class Poster {

    @SerializedName("id") protected          int    id;
    @SerializedName("screen_name") protected String screenName;
    @SerializedName("photo_50") protected    String photo50;
    @SerializedName("photo_100") protected   String photo100;

    @NonNull public abstract String getDisplayName();

    public int getId() {
        return id;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getPhoto50() {
        return photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

}
