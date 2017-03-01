package com.xi_zz.androidtest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DisplayTextTest
{
	@Rule
	public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

	@Test
	public void testTextShowAfterButtonClick()
	{
		onView(withId(R.id.display_text)).check(matches(withText("")));
		onView(withId(R.id.show_button)).perform(click());
		onView(withId(R.id.display_text)).check(matches(withText(R.string.hello_world)));
	}
}
