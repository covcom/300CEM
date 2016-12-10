package com.example.jianhuayang.navigationdrawer;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//import android.test.suitebuilder.annotation.SmallTest;

/**
 * Created by jianhuayang on 09/12/2016.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class EspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void clickButton() {
        onView(withId(R.id.f1)).perform(click());
        onView(withText("f2")).check(matches(isDisplayed()));
    }

    @Test
    public void openDrawer() {
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open());
        onView(withText("Swap")).perform(click());
        onView(withText("f2")).check(matches(isDisplayed()));
    }
}
