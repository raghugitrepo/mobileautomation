package com.test.android.testcases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.android.carousell.BaseTest;
import com.test.android.screens.HomeScreen;
import com.test.android.screens.LaunchScreen;
import com.test.android.screens.LoginScreen;

public class LoginPageTest extends BaseTest {

	LoginScreen loginScreen;
	HomeScreen homeScreen;
	LaunchScreen launchScreen;

	/*public LoginPageTest() {
		super();
	}*/

	@BeforeMethod
	public void setup() throws MalformedURLException {
		launchApp();
		launchScreen = new LaunchScreen(driver);
		loginScreen = new LoginScreen(driver);

	}

	@Test
	public void LoginTest() {
		launchScreen.gotoLoginButton();
		loginScreen.enterCredentials(appUser, password);
		loginScreen.submitLogin();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
