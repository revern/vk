package com.example.revern.vkontaktetest.login;

import android.support.annotation.NonNull;
import com.example.revern.vkontaktetest.utils.ui.BaseView;

public interface LoginView extends BaseView {

    void loadLoginUrl(@NonNull String loginUrl);

    void showNewsFeed();

}
