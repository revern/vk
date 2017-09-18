package com.example.revern.vkontaktetest.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Revern on 22.08.2017.
 */

public class StethoUtils {

    public static void initialize(@NonNull Context context) {
        Stetho.initializeWithDefaults(context);
    }

    public static void addInterceptors(@NonNull OkHttpClient.Builder httpClientBuilder) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClientBuilder.addInterceptor(interceptor);
        httpClientBuilder.addNetworkInterceptor(new StethoInterceptor());
    }

}
