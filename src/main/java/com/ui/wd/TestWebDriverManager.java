package com.utils.ui.wd;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * 
 * This class gives a WebDriver instance which is thread safe
 * 
 * 
 */
public class TestWebDriverManager {

	private static WebDriver webDriver;

	private static Logger LOGGER = Logger.getLogger(TestWebDriverManager.class);

	public static WebDriver getDriver() {
		if (webDriver != null) {
			LOGGER.info("Browser is already initiated...");
			return webDriver;
		}
		webDriver = WebDriverFactory.getWebDriverInstance();
		LOGGER.info("Maximizing the browser window: ");
		webDriver.manage().window().maximize();
		return webDriver;
	}

	public static void quitDriver() {
		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}
}
