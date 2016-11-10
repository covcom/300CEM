package com.example.jianhuayang.mytests;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by jianhuayang on 07/11/2015.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class InstrumentedDeadlineTest {

    private Deadline deadline;

    @Before
    public void initTests(){
//        http://stackoverflow.com/questions/30319838/android-junit4-testing-where-to-get-context-from
//        http://stackoverflow.com/questions/6011472/android-how-to-get-context-when-testing-with-activityinstrumentationtestcase2
//        google AndroidJUnit4 getcontext
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();

        deadline = new Deadline("09/12/15", context);
//        deadline = new Deadline("09/12/15");

    }

    @Test
    public void testCalculate(){
        Log.d("actual results", Integer.toString(deadline.calculate()));
        assertThat(deadline.calculate(), is(equalTo(9)));

    }

}
