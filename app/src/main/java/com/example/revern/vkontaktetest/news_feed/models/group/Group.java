package com.example.revern.vkontaktetest.news_feed.models.group;

import android.support.annotation.NonNull;

import com.example.revern.vkontaktetest.news_feed.models.Poster;
import com.example.revern.vkontaktetest.news_feed.models.base.BoolInt;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 20.08.2017.
 */

public class Group extends Poster {

    @SerializedName("name") private      String        name;
    @SerializedName("is_closed") private GroupIsClosed isClosed;
    @SerializedName("type") private      GroupType     type;
    @SerializedName("is_admin") private  BoolInt       isAdmin;
    @SerializedName("is_member") private BoolInt       isMember;
    @SerializedName("photo_200") private String        photo200;

    @NonNull @Override public String getDisplayName() {
        return name == null ? "" : name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public GroupIsClosed getIsClosed() {
        return isClosed;
    }

    public GroupType getType() {
        return type;
    }

    public boolean isAdmin() {
        return isAdmin == BoolInt.YES;
    }

    public boolean isMember() {
        return isMember == BoolInt.YES;
    }

    public String getPhoto50() {
        return photo50;
    }

    public String getPhoto100() {
        return photo100;
    }

    public String getPhoto200() {
        return photo200;
    }

}
