package com.example.revern.vkontaktetest.utils.network.models;

import com.example.revern.vkontaktetest.utils.Strings;

import java.util.List;
import java.util.Map;

public class CommonError {

    private Error error;

    public String getMessage() {
        String message = error.error == null ? "" : (error.error + '\n');
        if (error.validations != null) {
            for (String key : error.validations.keySet()) {
                message += key + " " + Strings.listToString(error.validations.get(key)) + '\n';
            }
        }
        return message;
    }

    public Map<String, List<String>> getValidations() {
        return error.validations;
    }

    public static class Error {
        private String                    error;
        private Map<String, List<String>> validations;
    }

}
