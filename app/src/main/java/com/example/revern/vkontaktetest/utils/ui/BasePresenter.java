package com.example.revern.vkontaktetest.utils.ui;

/**
 * Created by Revern on 24.07.2017.
 */

public class BasePresenter<V extends BaseView> {

    protected V view;

    public void attach(V view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

}
