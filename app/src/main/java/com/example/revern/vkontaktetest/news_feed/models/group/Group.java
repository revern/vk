package com.example.revern.vkontaktetest.news_feed.models.group;

import com.example.revern.vkontaktetest.news_feed.models.base.BoolInt;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 20.08.2017.
 */

public class Group {

    @SerializedName("id") private          int           id;
    @SerializedName("name") private        String        name;
    @SerializedName("screen_name") private String        screenName;
    @SerializedName("is_closed") private   GroupIsClosed isClosed;
    @SerializedName("type") private        GroupType     type;
    @SerializedName("is_admin") private    BoolInt       isAdmin;
    @SerializedName("is_member") private   BoolInt       isMember;
    @SerializedName("photo_50") private    String        photo50;
    @SerializedName("photo_100") private   String        photo100;
    @SerializedName("photo_200") private   String        photo200;

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
