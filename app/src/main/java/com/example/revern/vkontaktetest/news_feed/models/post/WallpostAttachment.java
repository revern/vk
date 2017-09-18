package com.example.revern.vkontaktetest.news_feed.models.post;

import com.example.revern.vkontaktetest.news_feed.models.Audio;
import com.example.revern.vkontaktetest.news_feed.models.Link;
import com.example.revern.vkontaktetest.news_feed.models.Photo;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Revern on 18.08.2017.
 */

public class WallpostAttachment {

    @SerializedName("type") private  WallpostAttachmentType type;
    @SerializedName("photo") private Photo                  photo;
    @SerializedName("audio") private Audio                  audio;
    @SerializedName("link") private  Link                   link;

    public WallpostAttachmentType getType() {
        return type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public Audio getAudio() {
        return audio;
    }

    public Link getLink() {
        return link;
    }

}
