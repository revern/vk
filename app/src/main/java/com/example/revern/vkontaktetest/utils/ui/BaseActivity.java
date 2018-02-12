package com.example.revern.vkontaktetest.utils.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.revern.vkontaktetest.R;
import com.example.revern.vkontaktetest.utils.Keyboard;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Revern on 24.07.2017.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity
    implements BaseView {

    @Inject protected       P       presenter;
    @BindView(R.id.toolbar) Toolbar toolbar;

    protected UiInfo uiInfo;

    @NonNull public abstract UiInfo createUserInfo();

    @Override protected void onCreate(Bundle savedInstanceState) {
        uiInfo = createUserInfo();

        super.onCreate(savedInstanceState);
        setContentView(uiInfo.getLayoutRes());

        if (getIntent() != null && getIntent().getExtras() != null) {
            parseArguments(getIntent().getExtras());
        }

        if (toolbar != null) {
            setToolbar(toolbar);
        }

        if (savedInstanceState != null) {
            restoreState(savedInstanceState);
        }
    }

    @Override protected void onStart() {
        super.onStart();
        presenter.attach(this);
    }

    @Override protected void onStop() {
        presenter.detach();
        super.onStop();
    }

    protected void parseArguments(@NonNull Bundle extras) {
    }

    protected void restoreState(@NonNull Bundle savedState) {
    }

    @Override public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    protected void setToolbar(@NonNull Toolbar toolbar) {
        setSupportActionBar(toolbar);
        if (uiInfo.getTitleRes() != 0) {
            setTitle(uiInfo.getTitleRes());
        } else if (uiInfo.getTitle() != null) {
            setTitle(uiInfo.getTitle());
        }
        if (uiInfo.hasBackButton() && getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        if (uiInfo.getMenuRes() != 0) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(uiInfo.getMenuRes(), menu);
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home && uiInfo.hasBackButton()) {
            Keyboard.hide(this);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override public void hideKeyboard() {
        Keyboard.hide(this);
    }

}
