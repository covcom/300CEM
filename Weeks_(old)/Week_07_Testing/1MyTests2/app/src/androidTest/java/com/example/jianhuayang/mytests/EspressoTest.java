package com.example.jianhuayang.mytests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by jianhuayang on 07/11/2015.
 */
@RunWith(AndroidJUnit4.class)
@SmallTest
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void changeText_sameActivity() {
        onView(withId(R.id.editText)).perform(typeText("17/12/15"), closeSoftKeyboard());
        onView(withId(R.id.buttonUpdate)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("1 days to 387COM deadline!")));
    }

    @Test
    public void changeText_newActivity() {
        onView(withId(R.id.editText)).perform(typeText("17/12/15"), closeSoftKeyboard());
        onView(withId(R.id.buttonSend)).perform(click());
        onView(withId(R.id.textView)).check(matches(withText("14 days until 2016!")));
    }
}
