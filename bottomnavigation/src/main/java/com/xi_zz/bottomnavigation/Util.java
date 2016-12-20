package com.xi_zz.bottomnavigation;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.view.View;

import java.lang.reflect.Field;

public class Util
{
	public static void removeShiftMode(BottomNavigationView view)
	{
		BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
		try
		{
			// stop shifting
			Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");

			shiftingMode.setAccessible(true);
			shiftingMode.setBoolean(menuView, false);
			shiftingMode.setAccessible(false);

			// remove text
			for (int i = 0; i < menuView.getChildCount(); i++)
			{
				BottomNavigationItemView menuItemView = (BottomNavigationItemView) menuView.getChildAt(i);
				menuItemView.getChildAt(1).setVisibility(View.GONE);
			}
		}
		catch (NoSuchFieldException e)
		{
		}
		catch (IllegalAccessException e)
		{
		}
	}
}
