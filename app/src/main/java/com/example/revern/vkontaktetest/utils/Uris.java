package com.example.revern.vkontaktetest.utils;

import android.support.annotation.NonNull;

public class Uris {

    @NonNull public static String getParamValueFromUrl(@NonNull String url, @NonNull String param) {
        return url
            .replaceAll(".*" + param + "=", "")
            .replaceAll("&.*", "");
    }

}
