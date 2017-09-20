package com.example.revern.vkontaktetest.utils;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Revern on 20.09.2017.
 */

public class Dates {

    @NonNull public static String getFormattedDate(long dateMillis) {
        Date date = new Date(dateMillis * 1000L);
        Date now = new Date();
        Date yesterday = new Date(now.getTime() - (24L * 60L * 60L * 1000L));
        if (date.getYear() == now.getYear() &&
            date.getMonth() == now.getMonth() &&
            date.getDay() == now.getDay()) {
            long secondsAgo = (now.getTime() - date.getTime()) / 1000L;
            if (secondsAgo < 5) {
                return "just now";
            } else if (secondsAgo / 60 == 0) {
                return secondsAgo + " seconds ago";
            } else if (secondsAgo / 60 / 60 == 0) {
                return secondsAgo / 60 + " minutes ago";
            } else {
                return secondsAgo / 60 / 60 + " hours ago";
            }
        } else if (date.getYear() == yesterday.getYear() &&
            date.getMonth() == yesterday.getMonth() &&
            date.getDay() == yesterday.getDay()) {
            SimpleDateFormat formatter = new SimpleDateFormat("'tomorrow at' hh:mm", Locale.ENGLISH);
            return formatter.format(date);
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy 'at' hh:mm", Locale.ENGLISH);
            return formatter.format(date);
        }
    }

}
