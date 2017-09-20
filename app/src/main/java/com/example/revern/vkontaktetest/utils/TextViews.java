package com.example.revern.vkontaktetest.utils;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Revern on 20.09.2017.
 */

public class TextViews {

    public static void setTextOrHide(@Nullable TextView textView, @Nullable int number) {
        setTextOrHide(textView, number + "");
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
