package com.example.revern.vkontaktetest.news_feed.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 20.08.2017.
 */

public class Audio {

    @SerializedName("id") private         int    id;
    @SerializedName("owner_id") private   int    ownerId;
    @SerializedName("artist") private     String artist;
    @SerializedName("title") private      String title;
    @SerializedName("url") private        String url;
    @SerializedName("access_key") private String accessKey;

    public Integer getId() {
        return id;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getAccessKey() {
        return accessKey;
    }

}
