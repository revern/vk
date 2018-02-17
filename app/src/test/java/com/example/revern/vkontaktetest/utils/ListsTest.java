package com.example.revern.vkontaktetest.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Revern on 17.02.2018.
 */

@RunWith(JUnit4.class)
public class ListsTest {

    @Test public void isEmptyTest() {
        List<Object> emptyList = new ArrayList<>();
        List<Object> nonEmptyList = new ArrayList<Object>() {{
            add(new Object());
        }};
        assertTrue(Lists.isEmpty(null));
        assertTrue(Lists.isEmpty(emptyList));
        assertFalse(Lists.isEmpty(nonEmptyList));
    }

}
