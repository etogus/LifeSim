package com.mamedovga.lifesim;

import static org.junit.Assert.*;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class NewGameActivityTest {

    @Rule
    public ActivityTestRule<NewGameActivity> activityTestRule = new ActivityTestRule<>(NewGameActivity.class);

    private int mImage = 2131296395;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testUserChooseImage() {
        Espresso.onView(ViewMatchers.withId(R.id.chooseAvatar)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.viewPagerImageSlider)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.putNewAvatarButton)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.chooseAvatar)).check(ViewAssertions.matches(ViewMatchers.withId(mImage)));
    }

    @After
    public void tearDown() throws Exception {
    }
}