package com.example.revern.vkontaktetest.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.View;
import android.widget.TextView;

public class TextViews {

    public static void setResponseText(@Nullable TextView textView, int number) {
        if (textView == null) return;

        textView.setText(getResponseString(number));
    }

    @NonNull @VisibleForTesting static String getResponseString(int number) {
        return number / 1000 > 0 ? number / 1000 + "K" : number + "";
    }

    public static void setTextOrHide(@Nullable TextView textView, @Nullable String text) {
        if (textView == null) return;

        if (Strings.isEmpty(text)) {
            textView.setVisibility(View.GONE);
        } else {
            textView.setVisibility(View.VISIBLE);
            textView.setText(text);
        }
    }

}
