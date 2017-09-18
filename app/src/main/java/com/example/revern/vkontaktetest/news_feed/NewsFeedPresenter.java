package com.example.revern.vkontaktetest.news_feed;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.revern.vkontaktetest.UserInteractor;
import com.example.revern.vkontaktetest.news_feed.models.NewsFeed;
import com.example.revern.vkontaktetest.news_feed.models.group.Group;
import com.example.revern.vkontaktetest.news_feed.models.post.Post;
import com.example.revern.vkontaktetest.news_feed.models.user.User;
import com.example.revern.vkontaktetest.utils.ui.BasePresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Revern on 17.08.2017.
 */

public class NewsFeedPresenter extends BasePresenter<NewsFeedView> {

    private final UserInteractor userInteractor;

    @NonNull private List<Post>  posts  = new ArrayList<>();
    @NonNull private List<User>  users  = new ArrayList<>();
    @NonNull private List<Group> groups = new ArrayList<>();

    public NewsFeedPresenter(@NonNull UserInteractor userInteractor) {
        this.userInteractor = userInteractor;
    }

    public void refreshNewsFeed() {
        userInteractor.getNewsFeed(100, null)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(response -> {
                refreshLists(response.getNewsFeed());
                if (view != null) {
                    view.refreshNews(posts);
                }
            });
    }

    public boolean isAuthorized() {
        return userInteractor.isAuthorized();
    }

    private void refreshLists(@Nullable NewsFeed newsFeed) {
        posts.clear();
        users.clear();
        groups.clear();
        if (newsFeed != null) {
            posts.addAll(newsFeed.getPosts());
            users.addAll(newsFeed.getProfiles());
            groups.addAll(newsFeed.getGroups());
        }
    }

    @NonNull public List<Post> getPosts() {
        return posts;
    }

    @NonNull public List<User> getUsers() {
        return users;
    }

    @NonNull public List<Group> getGroups() {
        return groups;
    }

}