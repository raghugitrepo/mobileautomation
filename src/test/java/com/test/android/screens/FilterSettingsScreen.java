package com.test.android.screens;

import org.openqa.selenium.support.PageFactory;

import com.test.android.carousell.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FilterSettingsScreen extends BaseTest{
	
	@AndroidFindBy(xpath= "//android.widget.RadioButton[@content-desc='time_created,descending']")
	MobileElement recentFilter;

	@AndroidFindBy(xpath= "//android.widget.Button[@resource-id='com.thecarousell.Carousell:id/btn_filter']")
	MobileElement applyFilter;
	
	public FilterSettingsScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void applyRecentFilter() {
		recentFilter.click();
		applyFilter.click();
	}

}
