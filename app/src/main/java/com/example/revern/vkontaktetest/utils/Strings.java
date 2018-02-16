package com.example.revern.vkontaktetest.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Collection;

/**
 * Created by Revern on 24.07.2017.
 */

public class Strings {

    public static boolean isEmpty(@Nullable String string) {
        return string == null || string.length() == 0;
    }

    @NonNull public static String listToString(@Nullable Collection<String> strings) {
        if (strings == null) return "";

        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string).append(", ");
        }
        if (result.length() > 0) {
            return result.substring(0, result.length() - 2);
        } else {
            return result.toString();
        }
    }

}
