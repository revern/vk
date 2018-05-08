package com.example.revern.vkontaktetest.utils.ui;

public class BasePresenter<V extends BaseView> {

    protected V view;

    public void attach(V view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

}
