package com.example.revern.vkontaktetest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.example.revern.vkontaktetest.login.LoginActivity;
import com.example.revern.vkontaktetest.news_feed.NewsFeedActivity;

/**
 * Created by Revern on 15.08.2017.
 */

public class Navigator {

    public static void showNewsFeed(@NonNull Context context) {
        context.startActivity(new Intent(context, NewsFeedActivity.class)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    public static void showLoginActivity(@NonNull Context context) {
        context.startActivity(new Intent(context, LoginActivity.class)
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

}
