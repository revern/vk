package com.example.revern.vkontaktetest.news_feed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.example.revern.vkontaktetest.Navigator;
import com.example.revern.vkontaktetest.R;
import com.example.revern.vkontaktetest.news_feed.models.NewsFeed;
import com.example.revern.vkontaktetest.news_feed.models.group.Group;
import com.example.revern.vkontaktetest.news_feed.models.post.Post;
import com.example.revern.vkontaktetest.news_feed.models.user.User;
import com.example.revern.vkontaktetest.news_feed.posts_rcv.PostHolder;
import com.example.revern.vkontaktetest.news_feed.posts_rcv.PostsAdapter;
import com.example.revern.vkontaktetest.utils.di.Injector;
import com.example.revern.vkontaktetest.utils.ui.BaseActivity;
import com.example.revern.vkontaktetest.utils.ui.UiInfo;
import com.example.revern.vkontaktetest.utils.ui.rcv.OnItemClickListener;

import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Revern on 17.08.2017.
 */

public class NewsFeedActivity extends BaseActivity<NewsFeedPresenter> implements NewsFeedView {

    @Bind(R.id.posts_rcv) RecyclerView uiPosts;

    private PostsAdapter adapter;

    @NonNull @Override public UiInfo createUserInfo() {
        return new UiInfo(R.layout.activity_news_feed)
            .setTitleRes(R.string.title_news_feed);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        Injector.inject(this);
        if (!presenter.isAuthorized()) Navigator.showLoginActivity(this);

        super.onCreate(savedInstanceState);

        initPostsList();

        if (savedInstanceState == null) {
            presenter.refreshNewsFeed();
        }

    }

    private void initPostsList() {
        adapter = new PostsAdapter(presenter.getPosts(),
            PostHolder.creator(presenter.getUsers(), presenter.getGroups()),
            null);
        uiPosts.setAdapter(adapter);
        uiPosts.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override public void showError(Throwable error) {

    }

    @Override
    public void refreshNews(@NonNull List<Post> posts) {
        adapter.setItems(posts);
    }

    @Override public boolean onKeyDown(int keyCode, KeyEvent event) {
//        presenter.refreshNewsFeed();
        return super.onKeyDown(keyCode, event);
    }
}
