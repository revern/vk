package com.example.revern.vkontaktetest.news_feed.models.user;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 20.08.2017.
 */

public enum Sex {

    @SerializedName("1")FEMALE(1),
    @SerializedName("2")MALE(2),
    @SerializedName("0")UNKNOWN(0);

    private final int value;

    Sex(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}