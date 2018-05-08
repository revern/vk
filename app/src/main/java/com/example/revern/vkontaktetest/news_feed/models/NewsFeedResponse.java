package com.example.revern.vkontaktetest.news_feed.models;

import com.google.gson.annotations.SerializedName;

public class NewsFeedResponse {

    @SerializedName("response") private NewsFeed newsFeed;

    public NewsFeed getNewsFeed() {
        return newsFeed;
    }

}
