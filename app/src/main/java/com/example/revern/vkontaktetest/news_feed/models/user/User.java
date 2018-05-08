package com.example.revern.vkontaktetest.news_feed.models.user;

import android.support.annotation.NonNull;

import com.example.revern.vkontaktetest.news_feed.models.Poster;
import com.example.revern.vkontaktetest.news_feed.models.base.BoolInt;
import com.google.gson.annotations.SerializedName;

public class User extends Poster {

    @SerializedName("first_name") private  String  firstName;
    @SerializedName("second_name") private String  secondName;
    @SerializedName("sex") private         Sex     sex;
    @SerializedName("online") private      BoolInt online;

    @NonNull @Override public String getDisplayName() {
        return (firstName == null ? "" : firstName) + " " + (secondName == null ? "" : secondName);
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

    public BoolInt getOnline() {
        return online;
    }
}
