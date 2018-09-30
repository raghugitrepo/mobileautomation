package com.test.android.screens;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.android.carousell.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends BaseTest {

	WebDriverWait wait = new WebDriverWait(driver, 15);

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(text(),'Log In')]")
	MobileElement loginHeader;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[contains(@content-desc,'Navigate up')]")
	MobileElement backButton;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	MobileElement username;

	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	MobileElement passwd;

	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.thecarousell.Carousell:id/login_button']")
	MobileElement loginPageLoginButton;

	public LoginScreen() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void enterCredentials(String user, String password) {
		
		wait.until(ExpectedConditions.visibilityOf(backButton));
		username.sendKeys(user);
		passwd.sendKeys(password);
	}

	public void submitLogin() {
		loginPageLoginButton.click();
	}
}
