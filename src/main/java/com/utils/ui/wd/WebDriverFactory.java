package com.utils.ui.wd;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.apache.log4j.lf5.viewer.configure.ConfigurationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.utils.ui.enums.Browser;
import com.utils.ui.utils.ConfigConstants;
import com.utils.ui.utils.ConfigManager;

/**
 * 
 * WebDriver factory that gives WebDriver instance based on browser type
 * 
 * 
 *
 */
public class WebDriverFactory {
	public static WebDriver getWebDriverInstance() {
		WebDriver driver = null;
			try {
		Map<String, String> envConfig = ConfigManager.getInstance().getConfig();
		String browser = envConfig.get(ConfigConstants.BROWSER);
		if (Browser.firefox.toString().equals(browser)) {
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setBrowserName(browser);
			driver = new RemoteWebDriver(new URL(envConfig.getOrDefault("firefoxserver","http://localhost:4442/wd/hub")), capabilities);
		} else if (Browser.chrome.toString().equals(browser)) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName(browser);
			driver = new RemoteWebDriver(new URL(envConfig.getOrDefault("chromeserver","http://localhost:4441/wd/hub")), capabilities);
		} else {
			throw new RuntimeException("Unsupported browser");
		}
	} catch (MalformedURLException e) {
		new AssertionError("Malformed URL " + e.getMessage());
	}
		return driver;
	}
}
