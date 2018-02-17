package com.example.revern.vkontaktetest.utils;

import android.support.annotation.NonNull;

/**
 * Created by Revern on 17.08.2017.
 */

public class Uris {

    @NonNull public static String getParamValueFromUrl(@NonNull String url, @NonNull String param) {
        return url
            .replaceAll(".*" + param + "=", "")
            .replaceAll("&.*", "");
    }

}
