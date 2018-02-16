package com.example.revern.vkontaktetest.utils.network;

import android.support.annotation.NonNull;

import com.example.revern.vkontaktetest.utils.Strings;
import com.example.revern.vkontaktetest.utils.storage.IStorage;

/**
 * Created by Revern on 27.07.2017.
 */

public class TokenHolder {

    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_USER_ID      = "user_id";

    @NonNull private final IStorage storage;

    public TokenHolder(@NonNull IStorage storage) {
        this.storage = storage;
    }

    public void saveSession(@NonNull String userId, @NonNull String token) {
        storage.putString(KEY_USER_ID, userId);
        storage.putString(KEY_ACCESS_TOKEN, token);
    }

    public String getToken() {
        return storage.getString(KEY_ACCESS_TOKEN);
    }

    public String getUserId() {
        return storage.getString(KEY_USER_ID);
    }

    public void clean() {
        storage.remove(KEY_ACCESS_TOKEN);
        storage.remove(KEY_USER_ID);
    }

    public boolean isUserAuthorized() {
        return !Strings.isEmpty(getToken());
    }

}
