package com.example.jianhuayang.mytests;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.test.suitebuilder.annotation.SmallTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by jianhuayang on 06/11/2015.
 */
@SmallTest
@RunWith(MockitoJUnitRunner.class)
public class DeadlineTest {

    @Mock
    Context context;

    @Mock
    Activity activity;

    @Mock
    SharedPreferences sharedPreferences;

    @Mock
    SharedPreferences.Editor editor;

    private Deadline deadline;


    @Test
    public void testCalculate() throws Exception {
        Deadline deadline = new Deadline("17/12/15");
        assertEquals(deadline.calculate(), 1);

    }

    @Test
    public void testCalculate2() throws Exception {
        Deadline deadline = new Deadline("16/12/15", context);
        assertThat("check if time interval is calculated properly", deadline.calculate(), is(equalTo(2)));

    }

    @Before
    public void initTests() {
        deadline = new Deadline("15/12/15", activity);
    }

    @Test
    public void testSave() throws Exception {

        when(activity.getPreferences(Context.MODE_PRIVATE)).thenReturn(sharedPreferences);
        when(sharedPreferences.edit()).thenReturn(editor);
        when(editor.commit()).thenReturn(true);
        assertThat(deadline.save(), is(true));
    }
}
