package com.test.android.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.android.carousell.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FilterSettingsScreen {
	
	AppiumDriver<MobileElement> driver = null;
	
	WebDriverWait wait = null;
	
	@AndroidFindBy(xpath= "//android.widget.RadioButton[@content-desc='time_created,descending']")
	MobileElement recentFilter;

	@AndroidFindBy(xpath= "//android.widget.Button[@resource-id='com.thecarousell.Carousell:id/btn_filter']")
	MobileElement applyFilter;
	
	public FilterSettingsScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		this.wait = new WebDriverWait(this.driver, 15);
	}
	
	public void applyRecentFilter() {
		recentFilter.click();
		applyFilter.click();
	}

}
