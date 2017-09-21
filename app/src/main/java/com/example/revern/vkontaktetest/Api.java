package com.example.revern.vkontaktetest;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.revern.vkontaktetest.news_feed.models.NewsFeedResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

import static com.example.revern.vkontaktetest.Api.METHOD;

/**
 * Created by Revern on 27.07.2017.
 */

public interface Api {
    String BASE_URL = BuildConfig.API_BASE_URL;
    String METHOD   = "/method/";

    @GET(BASE_URL + METHOD + "newsfeed.get") Observable<NewsFeedResponse> getNewsFeed(
        @Query("access_token") @Nullable String token,
        @Query("filters") @Nullable String filters,
        @Query("count") int count,
        @Query("start_from") @Nullable String startFrom,
        @Query("v") @Nullable String version
    );

}
