package com.example.revern.vkontaktetest.utils.ui;

import android.support.annotation.LayoutRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

public class UiInfo {

    @LayoutRes private final int     layoutRes;
    @StringRes private       int     titleRes;
    @MenuRes private         int     menuRes;
    private                  String  titleStr;
    private                  boolean hasBackButton;

    public UiInfo(@LayoutRes int layoutRes) {
        this.layoutRes = layoutRes;
    }

    @NonNull public UiInfo setMenuRes(@MenuRes int menuRes) {
        this.menuRes = menuRes;
        return this;
    }

    @NonNull public UiInfo setTitleRes(@StringRes int titleRes) {
        this.titleRes = titleRes;
        return this;
    }

    @NonNull public UiInfo setTitle(@NonNull String titleString) {
        this.titleStr = titleString;
        return this;
    }

    @NonNull public UiInfo enableBackButton() {
        this.hasBackButton = true;
        return this;
    }

    public int getLayoutRes() {
        return layoutRes;
    }

    public int getTitleRes() {
        return titleRes;
    }

    public int getMenuRes() {
        return menuRes;
    }

    @Nullable public String getTitle() {
        return titleStr;
    }

    public boolean hasBackButton() {
        return hasBackButton;
    }

}
