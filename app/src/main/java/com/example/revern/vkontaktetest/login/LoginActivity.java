package com.example.revern.vkontaktetest.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.revern.vkontaktetest.BuildConfig;
import com.example.revern.vkontaktetest.Navigator;
import com.example.revern.vkontaktetest.R;
import com.example.revern.vkontaktetest.utils.Scopes;
import com.example.revern.vkontaktetest.utils.di.Injector;
import com.example.revern.vkontaktetest.utils.ui.BaseActivity;
import com.example.revern.vkontaktetest.utils.ui.UiInfo;

import butterknife.Bind;

/**
 * Created by Revern on 15.08.2017.
 */

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    private static final int SCOPES =
        Scopes.FRIENDS
            + Scopes.WALL
            + Scopes.OFFLINE;

    private static final String LOGIN_URL = "https://oauth.vk.com/authorize" +
        "?client_id=" + BuildConfig.CLIENT_ID +
        "&redirect_uri=" + "https://oauth.vk.com/blank.html" +
        "&display=" + "mobile" +
        "&scope=" + SCOPES +
        "&response_type=" + "token" +
        "&v=" + BuildConfig.API_VERSION;

    @Bind(R.id.login_container) WebView uiLogin;

    @NonNull @Override public UiInfo createUserInfo() {
        return new UiInfo(R.layout.activity_login)
            .setTitleRes(R.string.title_login);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        Injector.inject(this);
        super.onCreate(savedInstanceState);

        uiLogin.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (presenter.isLoggedIn(url)) return false;

                view.loadUrl(url);
                return false;
            }
        });
        uiLogin.loadUrl(LOGIN_URL);
    }

    @Override public void showError(Throwable error) {
        //TODO remake
        Toast.makeText(this, error.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override public void showNewsFeed() {
        clearWebViewCache();
        Navigator.showNewsFeed(this);
    }

    private void clearWebViewCache() {
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
    }
}
