package com.example.revern.vkontaktetest.utils.di;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.example.revern.vkontaktetest.App;
import com.example.revern.vkontaktetest.login.LoginActivity;
import com.example.revern.vkontaktetest.news_feed.NewsFeedActivity;

/**
 * Created by Revern on 27.07.2017.
 */

public class Injector {

    private static AppComponent getAppComponent(@NonNull FragmentActivity initialScreen) {
        return ((App) initialScreen.getApplicationContext()).getAppComponent();
    }

    private static SessionComponent getSessionComponent(@NonNull FragmentActivity initialScreen) {
        return ((App) initialScreen.getApplicationContext()).getSessionComponent();
    }

    public static void inject(@NonNull App app) {
        app.getAppComponent().inject(app);
    }

    public static void inject(@NonNull LoginActivity loginActivity) {
        getSessionComponent(loginActivity).inject(loginActivity);
    }

    public static void inject(@NonNull NewsFeedActivity newsFeedActivity) {
        getSessionComponent(newsFeedActivity).inject(newsFeedActivity);
    }

}
