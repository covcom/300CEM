package com.example.jianhuayang.mytests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by yang on 11/11/16.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class InstrumentedDeadlineTest {

    private Deadline deadline;

    @Before
    public void initTests() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        deadline = new Deadline("04/12/16", context);
    }

    @Test
    public void testCalculate() {
        Log.d("actual_results", Integer.toString(deadline.calculate()));
        assertThat(deadline.calculate(), is(equalTo(9)));
    }

}
