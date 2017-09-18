package com.example.revern.vkontaktetest.news_feed.models.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 20.08.2017.
 */

public enum BoolInt {

    @SerializedName("0")NO(0),
    @SerializedName("1")YES(1);

    private final int value;

    BoolInt(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
