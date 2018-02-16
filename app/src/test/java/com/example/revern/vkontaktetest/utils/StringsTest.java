package com.example.revern.vkontaktetest.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Revern on 16.02.2018.
 */
@RunWith(JUnit4.class)
public class StringsTest {

    @Test public void isEmptyTest() {
        assertTrue(Strings.isEmpty(null));
        assertTrue(Strings.isEmpty(""));
        assertFalse(Strings.isEmpty("some text"));
    }

    @Test public void listToStringTest() {
        List<String> list = new ArrayList<String>() {{ add("1"); add("2"); add("3"); }};

        assertEquals("1, 2, 3", Strings.listToString(list));
        assertEquals("", Strings.listToString(null));
    }

}
