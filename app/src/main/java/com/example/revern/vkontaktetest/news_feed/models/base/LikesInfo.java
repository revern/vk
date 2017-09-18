package com.example.revern.vkontaktetest.news_feed.models.base;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 18.08.2017.
 */

public class LikesInfo {

    @SerializedName("count") private       int     count;
    @SerializedName("user_likes") private  int     userLikes;
    @SerializedName("can_like") private    BoolInt canLike;
    @SerializedName("can_publish") private BoolInt canPublish;

    public int getCount() {
        return count;
    }

    public int getUserLikes() {
        return userLikes;
    }

    public BoolInt getCanLike() {
        return canLike;
    }

    public BoolInt getCanPublish() {
        return canPublish;
    }

}
