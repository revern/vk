package com.example.revern.vkontaktetest.news_feed.models.user;

import com.example.revern.vkontaktetest.news_feed.models.base.BoolInt;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 20.08.2017.
 */

public class User {

    @SerializedName("id") private          String  id;
    @SerializedName("first_name") private  String  firstName;
    @SerializedName("second_name") private String  secondName;
    @SerializedName("sex") private         Sex     sex;
    @SerializedName("screen_name") private String  screenName;
    @SerializedName("photo_50") private    String  photo50;
    @SerializedName("photo_100") private   String  photo100;
    @SerializedName("online") private      BoolInt online;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Sex getSex() {
        return sex;
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

    public BoolInt getOnline() {
        return online;
    }
}
