package com.example.revern.vkontaktetest.news_feed.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Revern on 20.08.2017.
 */

public class Link {

    @SerializedName("url") private         String url;
    @SerializedName("title") private       String title;
    @SerializedName("caption") private     String caption;
    @SerializedName("description") private String description;
    @SerializedName("photo") private       Photo  photo;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getCaption() {
        return caption;
    }

    public String getDescription() {
        return description;
    }

    public Photo getPhoto() {
        return photo;
    }

}
