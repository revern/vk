package com.example.revern.vkontaktetest;

import android.support.annotation.Nullable;

import com.example.revern.vkontaktetest.news_feed.models.NewsFeedResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    String BASE_URL = BuildConfig.API_BASE_URL;
    String METHOD   = "/method/";

    @GET(BASE_URL + METHOD + "newsfeed.get") Single<NewsFeedResponse> getNewsFeed(
        @Query("access_token") @Nullable String token,
        @Query("filters") @Nullable String filters,
        @Query("count") int count,
        @Query("start_from") @Nullable String startFrom,
        @Query("v") @Nullable String version
    );

}
