package com.example.revern.vkontaktetest.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import butterknife.BindView;
import com.example.revern.vkontaktetest.Navigator;
import com.example.revern.vkontaktetest.R;
import com.example.revern.vkontaktetest.utils.di.Injector;
import com.example.revern.vkontaktetest.utils.ui.BaseActivity;
import com.example.revern.vkontaktetest.utils.ui.UiInfo;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.login_container) WebView uiLogin;

    @NonNull @Override public UiInfo createUserInfo() {
        return new UiInfo(R.layout.activity_login)
            .setTitleRes(R.string.title_login);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        Injector.inject(this);
        super.onCreate(savedInstanceState);

        initWebView();
    }

    @Override public void loadLoginUrl(@NonNull String loginUrl) {
        uiLogin.loadUrl(loginUrl);
    }

    @Override public void showNewsFeed() {
        clearWebViewCache();
        Navigator.showNewsFeed(this);
    }

    private void initWebView() {
        uiLogin.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (presenter.isLoggedIn(url)) return false;

                view.loadUrl(url);
                return false;
            }
        });
    }

    private void clearWebViewCache() {
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
    }

}
