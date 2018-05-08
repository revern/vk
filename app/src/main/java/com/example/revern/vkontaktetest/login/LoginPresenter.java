package com.example.revern.vkontaktetest.login;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.revern.vkontaktetest.utils.Uris;
import com.example.revern.vkontaktetest.utils.network.TokenHolder;
import com.example.revern.vkontaktetest.utils.ui.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginView> {

    private static final String PARAM_USER_ID      = "user_id";
    private static final String PARAM_ACCESS_TOKEN = "access_token";

    private final TokenHolder tokenHolder;

    public LoginPresenter(@NonNull TokenHolder tokenHolder) {
        this.tokenHolder = tokenHolder;
    }

    public boolean isLoggedIn(@Nullable String responseUrl) {
        if (responseUrl != null &&
            responseUrl.contains(PARAM_USER_ID) &&
            responseUrl.contains(PARAM_ACCESS_TOKEN)) {
            saveToken(responseUrl);

            return true;
        }
        return false;
    }

    private void saveToken(@NonNull String responseUrl) {
        String userId = Uris.getParamValueFromUrl(responseUrl, "user_id");
        String token = Uris.getParamValueFromUrl(responseUrl, "access_token");
        tokenHolder.saveSession(userId, token);

        if (view != null) {
            view.showNewsFeed();
        }
    }

}
