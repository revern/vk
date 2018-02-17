package com.example.revern.vkontaktetest.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Created by Revern on 17.02.2018.
 */

@RunWith(JUnit4.class)
public class UrisTest {

    @Test public void getParamValueFromUrlTest() {
        String param1 = "param1";
        String param2 = "param2";
        String value1 = "hello";
        String value2 = "world";
        String urlRequest = "https://vk.com?" + param1 + "=" + value1 + "&" + param2 + "=" + value2;

        assertEquals(value1, Uris.getParamValueFromUrl(urlRequest, param1));
        assertEquals(value2, Uris.getParamValueFromUrl(urlRequest, param2));
    }

}
