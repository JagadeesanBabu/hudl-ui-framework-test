package com.utils.ui.wd;

import org.apache.log4j.Logger;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;

import com.utils.ui.utils.ConfigConstants;
import com.utils.ui.utils.ConfigManager;

public class EnvInitializer extends TestWatcher {

	private static final Logger LOGGER = Logger.getLogger(EnvInitializer.class);

	private ConfigManager config = ConfigManager.getInstance();

	public ConfigManager getConfig() {
		return config;
	}
	private WebDriver driver;
	
	@Override
	protected void starting(Description description) {

		LOGGER.info(String.format("Started test class : %s", description.getClassName()));
		LOGGER.info("Initiating the browser");
		driver = TestWebDriverManager.getDriver();
		driver.get(config.getConfig().get(ConfigConstants.BASE_URL));
	}

	@Override
	protected void finished(Description description) {
		LOGGER.info(String.format("Finished test class : %s", description.getClassName()));
		LOGGER.info("Quitting the browser");
		TestWebDriverManager.quitDriver();
	}

}
