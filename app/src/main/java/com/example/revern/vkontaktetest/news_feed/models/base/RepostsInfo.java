package com.example.revern.vkontaktetest.news_feed.models.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 18.08.2017.
 */

public class RepostsInfo {

    @SerializedName("count") private         int     count;
    @SerializedName("user_reposted") private BoolInt userReposted;

    public int getCount() {
        return count;
    }

    public BoolInt getUserReposted() {
        return userReposted;
    }
}
