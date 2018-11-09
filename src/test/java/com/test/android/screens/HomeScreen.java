package com.test.android.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.android.carousell.BaseTest;
import com.test.android.utils.ReusableFunctions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen {
	
	AppiumDriver<MobileElement> driver = null;
	
	WebDriverWait wait = null;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.thecarousell.Carousell:id/button_sell']")
	MobileElement sellButton;

	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.thecarousell.Carousell:id/home_page_see_all_button']")
	MobileElement seeAllButton;

	@AndroidFindBy(xpath = ".//*[@text='Everything Else']")
	MobileElement everyThingElse;

	//@AndroidFindBy(uiAutomator = "new UiSelector().text('Everything Else')"
	//MobileElement everyThingElse;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.thecarousell.Carousell:id/bar_filter_title']")
	MobileElement filterMenu;


	public HomeScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		this.wait = new WebDriverWait(this.driver, 15);
	}

	public void waitUtilHomePageDisplay() {
		wait.until(ExpectedConditions.visibilityOf(sellButton));
	}

	public boolean verifyHomePage() {
		return sellButton.isDisplayed();

	}

	public void clickOnSeeAll() {
		seeAllButton.click();
	}

	public void scrollToEverythingElse() {
		do {
			ReusableFunctions.scroll();
		} while (!driver.getPageSource().contains("Everything Else"));
	}
	
	public void clickOnEverythingElse() {
		everyThingElse.click();
		
	}
	
	
	
	

}
