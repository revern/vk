package com.example.revern.vkontaktetest.utils.di;

import com.example.revern.vkontaktetest.App;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface AppComponent {

    SessionComponent plus(SessionModule sessionModule);

    void inject(App app);

}
