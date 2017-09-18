package com.example.revern.vkontaktetest.news_feed.models.base;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 18.08.2017.
 */

public class CommentsInfo {

    @SerializedName("count") private    int     count;
    @SerializedName("can_post") private BoolInt canPost;

    public int getCount() {
        return count;
    }

    public BoolInt getCanPost() {
        return canPost;
    }

}
