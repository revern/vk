package com.example.revern.vkontaktetest.news_feed;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.revern.vkontaktetest.Navigator;
import com.example.revern.vkontaktetest.R;
import com.example.revern.vkontaktetest.news_feed.models.post.Post;
import com.example.revern.vkontaktetest.news_feed.posts_rcv.PostHolder;
import com.example.revern.vkontaktetest.news_feed.posts_rcv.PostsAdapter;
import com.example.revern.vkontaktetest.utils.di.Injector;
import com.example.revern.vkontaktetest.utils.ui.BaseActivity;
import com.example.revern.vkontaktetest.utils.ui.UiInfo;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Revern on 17.08.2017.
 */

public class NewsFeedActivity extends BaseActivity<NewsFeedPresenter> implements NewsFeedView {

    @BindView(R.id.swipe_refresh_layout) SwipeRefreshLayout uiSwipeRefresh;
    @BindView(R.id.posts_rcv)            RecyclerView       uiPosts;

    private PostsAdapter adapter;

    @NonNull @Override public UiInfo createUserInfo() {
        return new UiInfo(R.layout.activity_news_feed)
            .setTitleRes(R.string.title_news_feed);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        Injector.inject(this);
        if (!presenter.isAuthorized()) showLogin();

        super.onCreate(savedInstanceState);

        initPostsList();
        initSwipeRefresh();

        if (savedInstanceState == null) {
            presenter.refreshNewsFeed();
        }

    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_news_feed, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                presenter.logout();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initSwipeRefresh() {
        uiSwipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        uiSwipeRefresh.setRefreshing(false);
        uiSwipeRefresh.setOnRefreshListener(() -> {
            uiSwipeRefresh.setRefreshing(true);
            presenter.refreshNewsFeed();
        });
    }

    private boolean isLoading;

    private void initPostsList() {
        adapter = new PostsAdapter(presenter.getPosts(),
            PostHolder.creator(presenter.getUsers(), presenter.getGroups()),
            null);
        uiPosts.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        uiPosts.setLayoutManager(linearLayoutManager);

        uiPosts.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0 && !isLoading &&
                    linearLayoutManager.findFirstVisibleItemPosition() + 20 > adapter.getItemCount()) {
                    isLoading = true;
                    presenter.loadMoreNews();
                }
            }
        });
    }

    @Override public void showError(Throwable error) {

    }

    @Override
    public void refreshNews(@NonNull List<Post> posts) {
        uiSwipeRefresh.setRefreshing(false);
        adapter.setItems(posts);
    }

    @Override public void addNews(@NonNull List<Post> posts) {
        isLoading = false;
        adapter.addItems(posts);
    }

    @Override public void showLogin() {
        Navigator.showLoginActivity(this);
    }

}
