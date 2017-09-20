package com.example.revern.vkontaktetest.utils;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by Revern on 20.09.2017.
 */

public class Lists {

    public static boolean isEmpty(@Nullable List list){
        return list == null || list.isEmpty();
    }

}
