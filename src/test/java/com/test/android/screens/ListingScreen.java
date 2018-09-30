package com.test.android.screens;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.android.carousell.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ListingScreen extends BaseTest{
	
	WebDriverWait wait = new WebDriverWait(driver, 15);
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.thecarousell.Carousell:id/bar_filter_title']")
	MobileElement filterMenu;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.thecarousell.Carousell:id/view_product']")
	MobileElement listingCard;

	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.thecarousell.Carousell:id/feature_button']")
	MobileElement banner;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id= 'com.thecarousell.Carousell:id/text_above_fold']")
	List<MobileElement> listingTime;
	
	public ListingScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void closebanner() {
		wait.until(ExpectedConditions.visibilityOf(banner));
		banner.click();
		
	}
	
	public void openFilterScreen() {
		filterMenu.click();
	}
	
	public void waitForlistingToDisplay() {
		wait.until(ExpectedConditions.visibilityOf(listingCard));
	}
	
	public void assertListingTiming() {
		String regex = "(\\d{1,2}m|moments)\\sago";
		for(MobileElement e : listingTime) {
			System.out.println(e.getText() + "listing time");
			assertTrue(e.getText().matches(regex), "older listings are displayed");
			
		}
	}

}
