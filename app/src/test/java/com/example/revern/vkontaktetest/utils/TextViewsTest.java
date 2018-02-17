package com.example.revern.vkontaktetest.utils;

import android.view.View;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by Revern on 17.02.2018.
 */
@RunWith(JUnit4.class)
public class TextViewsTest {
    @Mock private TextView uiMockedTV;

    @Before public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test public void getResponseStringTest() {
        assertEquals("0", TextViews.getResponseString(0));
        assertEquals("1K", TextViews.getResponseString(1000));
        assertEquals("2K", TextViews.getResponseString(2147));
    }

    @Test public void setResponseTextTest() {
        int anyInt = 0;
        TextViews.setResponseText(uiMockedTV, anyInt);
        verify(uiMockedTV).setText(TextViews.getResponseString(anyInt));
    }

    @Test public void setTextOrHideWithNotNullTextTest() {
        String notEmptyText = "Some Text";

        TextViews.setTextOrHide(uiMockedTV, notEmptyText);
        verify(uiMockedTV).setText(notEmptyText);
        verify(uiMockedTV).setVisibility(View.VISIBLE);
    }

    @Test public void setTextOrHideWithEmptyTextTest() {
        TextViews.setTextOrHide(uiMockedTV, "");
        verify(uiMockedTV).setVisibility(View.GONE);
    }

    @Test public void setTextOrHideWithNullTextTest() {
        TextViews.setTextOrHide(uiMockedTV, null);
        verify(uiMockedTV).setVisibility(View.GONE);
    }
}
