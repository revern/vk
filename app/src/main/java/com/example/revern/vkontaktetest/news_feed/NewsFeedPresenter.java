package com.example.revern.vkontaktetest.news_feed;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.revern.vkontaktetest.UserInteractor;
import com.example.revern.vkontaktetest.news_feed.models.NewsFeed;
import com.example.revern.vkontaktetest.news_feed.models.group.Group;
import com.example.revern.vkontaktetest.news_feed.models.post.Post;
import com.example.revern.vkontaktetest.news_feed.models.user.User;
import com.example.revern.vkontaktetest.utils.Lists;
import com.example.revern.vkontaktetest.utils.ui.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewsFeedPresenter extends BasePresenter<NewsFeedView> {

    private final UserInteractor userInteractor;

    private Disposable newsfeedDisposable;
    @NonNull private List<Post>  posts  = new ArrayList<>();
    @NonNull private List<User>  users  = new ArrayList<>();
    @NonNull private List<Group> groups = new ArrayList<>();

    @Nullable private String nextFrom;

    public NewsFeedPresenter(@NonNull UserInteractor userInteractor) {
        this.userInteractor = userInteractor;
    }

    public void refreshNewsFeed() {
        if (newsfeedDisposable == null) {
            newsfeedDisposable = userInteractor.getNewsFeed(40)
                .doAfterTerminate(() -> newsfeedDisposable = null)
                .subscribe(response -> {
                    refreshLists(response.getNewsFeed());
                    if (view != null) {
                        view.refreshNews(posts);
                    }
                }, error -> {
                    if (view != null) {
                        view.showError(error);
                    }
                });
        }
    }

    public void loadMoreNews() {
        if (newsfeedDisposable == null) {
            newsfeedDisposable = userInteractor.getNewsFeed(20, nextFrom)
                .doAfterTerminate(() -> newsfeedDisposable = null)
                .subscribe(response -> {
                    addLists(response.getNewsFeed());
                    List<Post> posts = response.getNewsFeed().getPosts();
                    if (view != null && posts != null) {
                        view.addNews(posts);
                    }
                }, error -> {
                    if (view != null) {
                        view.showError(error);
                    }
                });
        }
    }

    public boolean isAuthorized() {
        return userInteractor.isAuthorized();
    }

    private void refreshLists(@Nullable NewsFeed newsFeed) {
        clearLists();
        addLists(newsFeed);

        if (view != null) {
            view.refreshNews(posts);
        }
    }

    private void clearLists() {
        posts.clear();
        users.clear();
        groups.clear();
    }

    private void addLists(@Nullable NewsFeed newsFeed) {
        if (newsFeed != null) {
            Lists.addList(posts, newsFeed.getPosts());
            Lists.addList(users, newsFeed.getProfiles());
            Lists.addList(groups, newsFeed.getGroups());
            nextFrom = newsFeed.getNextFrom();
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

    public void logout() {
        userInteractor.logout();
        if (view != null) {
            view.showLogin();
        }
    }

}