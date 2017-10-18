package com.example.revern.vkontaktetest.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Revern on 20.09.2017.
 */

public class TextViews {

    public static void setResponseText(@Nullable TextView textView, @Nullable int number) {
        if (textView == null) return;

        textView.setText(getResponseString(number));
    }

    @NonNull private static String getResponseString(int number) {
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
