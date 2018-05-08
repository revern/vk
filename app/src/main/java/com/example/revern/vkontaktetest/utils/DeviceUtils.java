package com.example.revern.vkontaktetest.utils;

import android.content.Context;
import android.support.annotation.NonNull;

public class DeviceUtils {

    public static int getScreenWidthInPixels(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeightInPixels(@NonNull Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

}
