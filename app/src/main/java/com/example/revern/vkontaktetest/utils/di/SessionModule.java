package com.example.revern.vkontaktetest.utils.di;

import android.support.annotation.NonNull;

import com.example.revern.vkontaktetest.Api;
import com.example.revern.vkontaktetest.UserInteractor;
import com.example.revern.vkontaktetest.login.LoginPresenter;
import com.example.revern.vkontaktetest.news_feed.NewsFeedPresenter;
import com.example.revern.vkontaktetest.utils.network.TokenHolder;
import com.example.revern.vkontaktetest.utils.storage.IStorage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Revern on 27.07.2017.
 */

@Module
public class SessionModule {

    @Provides @Singleton
    public LoginPresenter provideLoginPresenter(@NonNull TokenHolder tokenHolder) {
        return new LoginPresenter(tokenHolder);
    }

    @Provides @Singleton
    public NewsFeedPresenter provideNewsFeedPresenter(@NonNull UserInteractor userInteractor) {
        return new NewsFeedPresenter(userInteractor);
    }

}
