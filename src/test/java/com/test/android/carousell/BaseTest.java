package com.test.android.carousell;

import com.test.android.utils.EventListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class BaseTest {

	public static AppiumDriver<MobileElement> driver;
	public static Properties prop;
	public static EventFiringWebDriver E_Handler;
	public static AppiumDriverLocalService appiumService;
	public static String appiumServiceUrl;
	public static AppiumServiceBuilder builder;
	public static String currentDir = System.getProperty("user.dir");
	public static String appUser; 
	public static String password; 

	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/com/test" + "/android/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void launchApp() throws MalformedURLException {
		// Start appium server
		// commenting for now to get script logs instead.
		// startAppium();

		// Settings capabilities for appium seession
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("androidPlatform"));
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("androidPlatformVersion"));
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("andriodDeviceName"));
		caps.setCapability("automationName", "uiautomator2");
		caps.setCapability("disableWindowAnimation", "true");
		caps.setCapability("appPackage", prop.getProperty("androidAppPackageName"));
		caps.setCapability("appActivity", prop.getProperty("androidAppActivity"));
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver, new EventListener());
		
		appUser = prop.getProperty("username");
		password = prop.getProperty("password");

	}

	public static void startAppium() {
		try {
			if (appiumService != null) {
				appiumService.stop();

			}
			builder = new AppiumServiceBuilder();
			builder.withLogFile(new File(currentDir + "/appiumLogs/" + System.currentTimeMillis() + ".text"));

			appiumService = AppiumDriverLocalService.buildService(builder);
			appiumService.start();
			appiumServiceUrl = appiumService.getUrl().toString();
			System.out.println("Appium server started at: - " + appiumServiceUrl);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}