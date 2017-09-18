package com.example.revern.vkontaktetest.news_feed.models.post;

import com.example.revern.vkontaktetest.news_feed.models.base.CommentsInfo;
import com.example.revern.vkontaktetest.news_feed.models.base.LikesInfo;
import com.example.revern.vkontaktetest.news_feed.models.base.RepostsInfo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Revern on 18.08.2017.
 */

public class Post {

    @SerializedName("post_id") private      int                      postId;
    @SerializedName("source_id") private    int                      sourceId;
    @SerializedName("text") private         String                   text;
    @SerializedName("date") private         long                     date;
    @SerializedName("copy_history") private List<Wallpost>           copyHistory;
    @SerializedName("attachments") private  List<WallpostAttachment> attachments;
    @SerializedName("comments") private     CommentsInfo             comments;
    @SerializedName("likes") private        LikesInfo                likes;
    @SerializedName("reposts") private      RepostsInfo              reposts;

    public int getPostId() {
        return postId;
    }

    public int getSourceId() {
        return sourceId;
    }

    public String getText() {
        return text;
    }

    public long getDate() {
        return date;
    }

    public List<Wallpost> getCopyHistory() {
        return copyHistory;
    }

    public List<WallpostAttachment> getAttachments() {
        return attachments;
    }

    public CommentsInfo getComments() {
        return comments;
    }

    public LikesInfo getLikes() {
        return likes;
    }

    public RepostsInfo getReposts() {
        return reposts;
    }

}
