package com.example.revern.vkontaktetest.utils.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.example.revern.vkontaktetest.utils.storage.IStorage;
import com.example.revern.vkontaktetest.utils.storage.Storage;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private final Application application;

    public AppModule(@NonNull Application application) {
        this.application = application;
    }

    @Provides @Singleton
    public Context provideApplication() {
        return application;
    }

    @Provides @Singleton
    public Gson provideMapper() {
        return new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create();
    }

    @Provides @Singleton
    public SharedPreferences provideSharedPreferences(@NonNull Context context) {
        return context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }

    @Provides @Singleton
    public IStorage provideStorage(@NonNull SharedPreferences sharedPreferences,
                                   @NonNull Gson mapper) {
        return new Storage(sharedPreferences, mapper);
    }

}
