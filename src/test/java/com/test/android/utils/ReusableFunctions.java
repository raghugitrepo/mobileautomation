package com.test.android.utils;

import org.openqa.selenium.Dimension;

import com.test.android.carousell.BaseTest;

public class ReusableFunctions extends BaseTest {
	
	public static void scroll() {
		Dimension dimensions = driver.manage().window().getSize();
		int Startpoint = (int) (dimensions.getHeight() * 0.5);
		int scrollEnd = (int) (dimensions.getHeight() * 0.2);
		driver.swipe(200, Startpoint, 200, scrollEnd, 2000);
	}

}
