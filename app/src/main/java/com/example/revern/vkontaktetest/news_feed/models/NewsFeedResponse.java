package com.example.revern.vkontaktetest.news_feed.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 18.08.2017.
 */

public class NewsFeedResponse {

    @SerializedName("response") private NewsFeed newsFeed;

    public NewsFeed getNewsFeed() {
        return newsFeed;
    }

}
