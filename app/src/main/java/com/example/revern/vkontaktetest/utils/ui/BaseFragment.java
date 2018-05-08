package com.example.revern.vkontaktetest.utils.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.revern.vkontaktetest.utils.Keyboard;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {

    @Inject protected P presenter;

    @LayoutRes public abstract int getLayoutRes();

    @Override public void onCreate(@Nullable Bundle savedState) {
        super.onCreate(savedState);
        if (getArguments() != null) {
            parseArguments(getArguments());
        }
        if (savedState != null) {
            restoreState(savedState);
        }
    }

    @Override public void onStart() {
        super.onStart();
        presenter.attach(this);
    }

    @Override public void onStop() {
        presenter.detach();
        super.onStop();
    }

    protected void parseArguments(@NonNull Bundle arguments) {
    }

    public void restoreState(@NonNull Bundle savedState) {
    }

    @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater,
                                                 @Nullable ViewGroup container,
                                                 @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutRes(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override public void hideKeyboard() {
        Keyboard.hide(getActivity());
    }

}
