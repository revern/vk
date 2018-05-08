package com.example.revern.vkontaktetest.news_feed.models.post;

import com.example.revern.vkontaktetest.news_feed.models.base.ViewsInfo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Wallpost {

    @SerializedName("id") private          int                      id;
    @SerializedName("from_id") private     int                      fromId;
    @SerializedName("owner_id") private    int                      ownerId;
    @SerializedName("date") private        int                      date;
    @SerializedName("views") private       ViewsInfo                views;
    @SerializedName("text") private        String                   text;
    @SerializedName("signer_id") private   int                      signerId;
    @SerializedName("attachments") private List<WallpostAttachment> attachments;

    public int getId() {
        return id;
    }

    public int getFromId() {
        return fromId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public int getDate() {
        return date;
    }

    public ViewsInfo getViews() {
        return views;
    }

    public String getText() {
        return text;
    }

    public int getSignerId() {
        return signerId;
    }

    public List<WallpostAttachment> getAttachments() {
        return attachments;
    }

}
