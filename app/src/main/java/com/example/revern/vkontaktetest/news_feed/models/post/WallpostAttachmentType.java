package com.example.revern.vkontaktetest.news_feed.models.post;

import com.google.gson.annotations.SerializedName;

public enum WallpostAttachmentType {

    @SerializedName("photo")PHOTO("photo"),
    @SerializedName("audio")AUDIO("audio"),
    @SerializedName("video")VIDEO("video"),
    @SerializedName("doc")DOC("doc"),
    @SerializedName("link")LINK("link");

    private final String value;

    WallpostAttachmentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
