package com.example.revern.vkontaktetest.utils.network.models;

import com.example.revern.vkontaktetest.utils.Strings;

import java.util.List;
import java.util.Map;

public class CommonError {

    private Error error;

    public String getMessage() {
        StringBuilder message = new StringBuilder(error.error == null ? "" : (error.error + '\n'));
        if (error.validations != null) {
            for (String key : error.validations.keySet()) {
                message.append(key).append(" ").append(Strings.listToString(error.validations.get(key))).append('\n');
            }
        }
        return message.toString();
    }

    public Map<String, List<String>> getValidations() {
        return error.validations;
    }

    public static class Error {
        private String                    error;
        private Map<String, List<String>> validations;
    }

}
