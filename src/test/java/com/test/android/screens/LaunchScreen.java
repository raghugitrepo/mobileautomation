package com.test.android.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.test.android.carousell.BaseTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LaunchScreen {
	
	AppiumDriver<MobileElement> driver = null;
	
	WebDriverWait wait = null;
	
	@AndroidFindBy(xpath= "//android.widget.Button[@resource-id='com.thecarousell.Carousell:id/login_button']")
	MobileElement launchScreenLoginButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.google.android.gms:id/cancel']")
	MobileElement noneOfTheAboveOption;
	
	public LaunchScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		this.wait = new WebDriverWait(this.driver, 15);
	}



	public void gotoLoginButton() {
		try {
			if(launchScreenLoginButton.isDisplayed()) 
				launchScreenLoginButton.click();
			wait.until(ExpectedConditions.visibilityOf(noneOfTheAboveOption));
			noneOfTheAboveOption.click();
			
			} catch(ElementNotFoundException e) {
			e.printStackTrace();
			
		}
		
	}
	
	

}
