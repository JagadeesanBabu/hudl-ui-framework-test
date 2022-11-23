package com.utils.ui.utils;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Stopwatch;
import com.utils.ui.wd.TestWebDriverManager;

public class PageLauncher {

	private static final Logger LOGGER = Logger.getLogger(PageLauncher.class);

	private static Stopwatch stopWatch;

	public static String getCurrentUrl() {
		return TestWebDriverManager.getDriver().getCurrentUrl();
	}

	public static void waitForConditionSatisfied(Callable<Boolean> call, String message) {
		stopWatch = Stopwatch.createStarted();
		try {
			Wait<Callable<Boolean>> wait = new FluentWait<>(call).withTimeout(Duration.ofSeconds(30))
					.pollingEvery(Duration.ofSeconds(1)).ignoring(StaleElementReferenceException.class)
					.ignoring(NoSuchElementException.class).withMessage(message);

			wait.until(isTrue());
			stopWatch.stop();

		} catch (Exception e) {
			throw new AssertionError(e.getMessage());
		}
	}

	private static Function<Callable<Boolean>, Boolean> isTrue() {
		return new Function<Callable<Boolean>, Boolean>() {
			@Override
			public Boolean apply(Callable<Boolean> t) {
				try {
					LOGGER.info("Waiting Time: " + stopWatch.elapsed(TimeUnit.SECONDS) + " Seconds");
					return t.call();
				} catch (Exception e) {
					LOGGER.info("Exception after waiting: " + stopWatch.elapsed(TimeUnit.SECONDS) + " Seconds");
					throw new AssertionError(e.getMessage());
				}
			}
		};
	}

	public static void launchHomePage() {
		launchPage(ConfigManager.getInstance().getConfig().get(ConfigConstants.BASE_URL)+ "/home");
	}
	
	public static void launchLoginPage() {
		launchPage(ConfigManager.getInstance().getConfig().get(ConfigConstants.BASE_URL) + "/login");
	}
	
	private static void launchPage(String page) {
		TestWebDriverManager.getDriver().get(page);
	}
	
	public static void assertCurrentUrlEndsWith(String exp) {
		Callable<Boolean> call = () -> getCurrentUrl().endsWith(exp);
		waitForConditionSatisfied(call, "");
		assertThat(getCurrentUrl()).endsWith(exp);
	}
}
