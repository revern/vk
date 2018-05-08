package com.example.revern.vkontaktetest;

import android.app.Application;

import com.example.revern.vkontaktetest.utils.StethoUtils;
import com.example.revern.vkontaktetest.utils.di.AppComponent;
import com.example.revern.vkontaktetest.utils.di.AppModule;
import com.example.revern.vkontaktetest.utils.di.DaggerAppComponent;
import com.example.revern.vkontaktetest.utils.di.NetModule;
import com.example.revern.vkontaktetest.utils.di.SessionComponent;
import com.example.revern.vkontaktetest.utils.di.SessionModule;

public class App extends Application {

    private AppComponent     appComponent;
    private SessionComponent sessionComponent;

    @Override public void onCreate() {
        super.onCreate();

        initDaggerComponents();
        StethoUtils.initialize(this);
    }

    private void initDaggerComponents() {
        appComponent = createAppComponent();
        sessionComponent = appComponent.plus(new SessionModule());
    }

    protected AppComponent createAppComponent() {
        return DaggerAppComponent.builder()
            .appModule(new AppModule(this))
            .netModule(new NetModule(BuildConfig.API_BASE_URL))
            .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public SessionComponent getSessionComponent() {
        return sessionComponent;
    }

}
