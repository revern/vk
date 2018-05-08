package com.example.revern.vkontaktetest.utils.di;

import com.example.revern.vkontaktetest.login.LoginActivity;
import com.example.revern.vkontaktetest.news_feed.NewsFeedActivity;

import javax.inject.Singleton;

import dagger.Subcomponent;

@Singleton
@Subcomponent(modules = {SessionModule.class})
public interface SessionComponent {

    void inject(LoginActivity loginActivity);

    void inject(NewsFeedActivity newsFeedActivity);

}
