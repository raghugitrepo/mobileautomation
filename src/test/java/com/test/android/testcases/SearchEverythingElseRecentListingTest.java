package com.test.android.testcases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.android.carousell.BaseTest;
import com.test.android.screens.FilterSettingsScreen;
import com.test.android.screens.HomeScreen;
import com.test.android.screens.LaunchScreen;
import com.test.android.screens.ListingScreen;
import com.test.android.screens.LoginScreen;

public class SearchEverythingElseRecentListingTest extends BaseTest {

	LoginScreen loginScreen;
	HomeScreen homeScreen;
	LaunchScreen launchScreen;
	FilterSettingsScreen filterScreen;
	ListingScreen listingScreen;
	
	public SearchEverythingElseRecentListingTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws MalformedURLException {
		launchApp();
		launchScreen = new LaunchScreen();
		loginScreen = new LoginScreen();
		homeScreen = new HomeScreen();
		filterScreen = new FilterSettingsScreen();
		listingScreen = new ListingScreen();

	}

	@Test
	public void searchEverythingElse() {
		// login to app
		launchScreen.gotoLoginButton();
		loginScreen.enterCredentials(appUser, password);
		loginScreen.submitLogin();
		
		// verify homepage 
		homeScreen.waitUtilHomePageDisplay();
		homeScreen.verifyHomePage();
		
		// Select category as Everything Else 
		homeScreen.clickOnSeeAll();
		homeScreen.scrollToEverythingElse();
		homeScreen.clickOnEverythingElse();
		listingScreen.closebanner();
		
		// Apply Recent filter
		listingScreen.openFilterScreen();
		filterScreen.applyRecentFilter();
		
		// Wait for listing page to display results and verify listing cards 
		listingScreen.waitForlistingToDisplay();
		listingScreen.assertListingTiming();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
