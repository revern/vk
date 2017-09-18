package com.example.revern.vkontaktetest.news_feed.models.group;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 20.08.2017.
 */

public enum GroupType {

    @SerializedName("group")GROUP("group"),
    @SerializedName("page")PAGE("page"),
    @SerializedName("event")EVENT("event");

    private final String value;

    GroupType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
