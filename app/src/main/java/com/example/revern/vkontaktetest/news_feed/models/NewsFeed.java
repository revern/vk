package com.example.revern.vkontaktetest.news_feed.models;

import com.example.revern.vkontaktetest.news_feed.models.group.Group;
import com.example.revern.vkontaktetest.news_feed.models.post.Post;
import com.example.revern.vkontaktetest.news_feed.models.user.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Revern on 18.08.2017.
 */

public class NewsFeed {

    @SerializedName("items") private     List<Post>  posts;
    @SerializedName("profiles") private  List<User>  profiles;
    @SerializedName("groups") private    List<Group> groups;
    @SerializedName("next_from") private String      nextFrom;

    public List<Post> getPosts() {
        return posts;
    }

    public List<User> getProfiles() {
        return profiles;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public String getNextFrom() {
        return nextFrom;
    }
}
