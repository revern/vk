package com.example.revern.vkontaktetest.utils;

import android.support.annotation.Nullable;

import java.util.List;

public class Lists {

    public static boolean isEmpty(@Nullable List list) {
        return list == null || list.isEmpty();
    }

    @Nullable public static <T> List<T> addList(@Nullable List<T> list1, @Nullable List<T> list2) {
        if (list1 != null && list2 != null) {
            list1.addAll(list2);
        }
        return list1;
    }

}
