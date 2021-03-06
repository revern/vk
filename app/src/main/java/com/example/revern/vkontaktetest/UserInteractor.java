package com.example.revern.vkontaktetest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.revern.vkontaktetest.news_feed.models.NewsFeedResponse;
import com.example.revern.vkontaktetest.utils.RxUtils;
import com.example.revern.vkontaktetest.utils.network.TokenHolder;
import com.example.revern.vkontaktetest.utils.storage.IStorage;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class UserInteractor {

    private final IStorage    storage;
    private final Api         api;
    private final TokenHolder tokenHolder;

    public UserInteractor(@NonNull IStorage storage, @NonNull Api api,
                          @NonNull TokenHolder tokenHolder) {
        this.storage = storage;
        this.api = api;
        this.tokenHolder = tokenHolder;
    }

    @Nullable public String getToken() {
        return tokenHolder.getToken();
    }

    @Nullable public String getUserId() {
        return tokenHolder.getUserId();
    }

    public boolean isAuthorized() {
        return getToken() != null;
    }

    public Single<NewsFeedResponse> getNewsFeed(int count, @Nullable String startFrom) {
        return api.getNewsFeed(getToken(), "post", count, startFrom, BuildConfig.API_VERSION)
            .compose(RxUtils.doInBackgroundDeliverToUI());
    }

    public Single<NewsFeedResponse> getNewsFeed(int count) {
        return getNewsFeed(count, null);
    }

    public void logout() {
        tokenHolder.clean();
    }

}