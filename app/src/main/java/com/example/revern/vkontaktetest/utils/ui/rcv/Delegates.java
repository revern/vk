package com.example.revern.vkontaktetest.utils.ui.rcv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revern on 19.10.2017.
 */

public class Delegates {

    protected List<Class<?>>      delegateClasses;
    protected List<BaseHolder<?>> delegateHolders;

    public Delegates() {
        delegateClasses = new ArrayList<>();
        delegateHolders = new ArrayList<>();
    }

    public <T> void addDelegate(@NonNull Class<? extends T> clazz,
                                @NonNull BaseHolder<T> holder) {
        if (!delegateClasses.contains(clazz)) {
            delegateClasses.add(clazz);
            delegateHolders.add(holder);
        }
    }

    public void removeDelegate(@NonNull Class<?> clazz) {
        if (delegateClasses.contains(clazz)) {
            int index = delegateClasses.indexOf(clazz);
            delegateClasses.remove(index);
            delegateHolders.remove(index);
        }
    }

    public void removeAllDeleages() {
        delegateClasses.clear();
        delegateHolders.clear();
    }

    public int getClazzPosition(@NonNull Class<?> clazz) {
        return delegateClasses.indexOf(clazz);
    }

    public BaseHolder getHolder(int typePosition) {
        return delegateHolders.get(typePosition);
    }

}
