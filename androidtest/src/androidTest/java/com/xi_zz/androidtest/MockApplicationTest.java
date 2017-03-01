package com.xi_zz.androidtest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class MockApplicationTest
{
	@Rule
	public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

	@Test
	public void testApplicationName() throws Exception
	{
		assertEquals("TestApplication", mActivityRule.getActivity().getApplication().getClass().getSimpleName());
	}
}
