package com.example.revern.vkontaktetest.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.revern.vkontaktetest.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Dates {

    @NonNull public static String getFormattedDate(@NonNull Context context, long dateMillis) {
        Date date = new Date(dateMillis * 1000L);
        Date now = new Date();
        Date yesterday = new Date(now.getTime() - (24L * 60L * 60L * 1000L));
        if (date.getYear() == now.getYear() &&
            date.getMonth() == now.getMonth() &&
            date.getDay() == now.getDay()) {
            long secondsAgo = (now.getTime() - date.getTime()) / 1000L;
            if (secondsAgo < 5) {
                return context.getString(R.string.date_just_now);
            } else if (secondsAgo / 60 == 0) {
                return secondsAgo + " " + context.getString(R.string.date_seconds_ago);
            } else if (secondsAgo / 60 / 60 == 0) {
                return secondsAgo / 60 + " " + context.getString(R.string.date_minutes_ago);
            } else {
                return secondsAgo / 60 / 60 + " " + context.getString(R.string.date_hours_ago);
            }
        } else if (date.getYear() == yesterday.getYear() &&
            date.getMonth() == yesterday.getMonth() &&
            date.getDay() == yesterday.getDay()) {
            String tomorrowAt = context.getString(R.string.date_tomorrow_at);
            SimpleDateFormat formatter = new SimpleDateFormat("'" + tomorrowAt + "' hh:mm", Locale.ENGLISH);
            return formatter.format(date);
        } else {
            String at = context.getString(R.string.date_at);
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy '" + at + "' hh:mm", Locale.ENGLISH);
            return formatter.format(date);
        }
    }

}
