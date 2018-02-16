package com.example.revern.vkontaktetest.utils.di;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.revern.vkontaktetest.Api;
import com.example.revern.vkontaktetest.BuildConfig;
import com.example.revern.vkontaktetest.UserInteractor;
import com.example.revern.vkontaktetest.utils.StethoUtils;
import com.example.revern.vkontaktetest.utils.network.StringConverterFactory;
import com.example.revern.vkontaktetest.utils.network.TokenHolder;
import com.example.revern.vkontaktetest.utils.storage.IStorage;
import com.google.gson.Gson;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Revern on 27.07.2017.
 */

@Module
public class NetModule {

    @NonNull private String baseUrl = BuildConfig.API_BASE_URL;

    public NetModule(@NonNull String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides @Singleton
    public TokenHolder provideTokenHolder(@NonNull IStorage storage) {
        return new TokenHolder(storage);
    }

    @Provides @Singleton
    public File getCacheDir(@NonNull Context context) {
        final File external = context.getExternalCacheDir();
        return external != null ? external : context.getCacheDir();
    }

    @Provides @Singleton
    public OkHttpClient provideHttpClient(@NonNull TokenHolder tokenHolder,
                                          @NonNull File cachedDir) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.cache(new Cache(cachedDir, 20 * 1024 * 1024));
        httpClientBuilder.readTimeout(30, TimeUnit.SECONDS);

        StethoUtils.addInterceptors(httpClientBuilder);

        httpClientBuilder.addInterceptor(chain -> {
//            if (userSettings.userHasToken()) {
//                Request request = chain.request().newBuilder()
//                    .addHeader("X-User-Token", userSettings.getToken())
//                    .addHeader("X-User-Phone-Number", userSettings.getPhone())
//                    .build();
//                return chain.proceed(request);
//            }
            return chain.proceed(chain.request());
        });
        return httpClientBuilder.build();
    }

    @Provides @Singleton
    public Api provideApi(@NonNull OkHttpClient httpClient, @NonNull Gson mapper) {
        return new Retrofit.Builder()
            .client(httpClient)
            .baseUrl(baseUrl)
//            .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create()) //for rxjava 1
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(StringConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(mapper))
            .build()
            .create(Api.class);
    }

    @Provides @Singleton
    public UserInteractor provideUserInteractor(@NonNull IStorage storage, @NonNull Api api,
                                                @NonNull TokenHolder tokenHolder) {
        return new UserInteractor(storage, api, tokenHolder);
    }

}
