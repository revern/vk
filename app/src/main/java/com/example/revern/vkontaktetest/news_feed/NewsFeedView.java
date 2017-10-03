package com.example.revern.vkontaktetest.news_feed;

import android.support.annotation.NonNull;

import com.example.revern.vkontaktetest.news_feed.models.post.Post;
import com.example.revern.vkontaktetest.utils.ui.BaseView;

import java.util.List;

/**
 * Created by Revern on 17.08.2017.
 */

public interface NewsFeedView extends BaseView {

    void refreshNews(@NonNull List<Post> posts);

    void addNews(@NonNull List<Post> posts);

    void showLogin();

}
