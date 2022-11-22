package com.test.ui;
import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import com.utils.ui.pages.homepage.HomePage;
import com.utils.ui.pages.login.LoginPage;
import com.utils.ui.utils.ConfigConstants;
import com.utils.ui.utils.PageLauncher;
import com.utils.ui.wd.EnvInitializer;
import com.utils.ui.wd.TestMethodWatcher;

public class HudlLoginPageTest {

	@ClassRule
	public static EnvInitializer envInitializer = new EnvInitializer();

	@Rule
	public TestMethodWatcher testWatcher = new TestMethodWatcher();

	String username = envInitializer.getConfig().getConfig().get(ConfigConstants.USERNAME);
	String password = envInitializer.getConfig().getConfig().get(ConfigConstants.PASSWORD);

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void testLoginPageElements() {
		PageLauncher.launchLoginPage();
		loginPage.getSignUpLink().assertDisplayed();
		loginPage.getUserEmailTextBox().assertDisplayed();
		loginPage.getPasswordTextBox().assertDisplayed();
		loginPage.getSignInButton().assertDisplayed();
		loginPage.getUserEmailTextBox().assertDisplayed();
		loginPage.getUserEmailTextBox().assertDisplayed();
	}
	
	@Test
	public void testSuccessfulLogin() {
		PageLauncher.launchLoginPage();
		loginPage.login(username, password);
		PageLauncher.assertCurrentUrlEndsWith("home");
		homePage.assertHomePageElementsDisplayed();
	}

	@Test
	public void testEmptyUsername() {
		PageLauncher.launchLoginPage();
		loginPage.login("", "dummy");
		loginPage.assertLoginError();
	}
	
	@Test
	public void testEmptyPassword() {
		PageLauncher.launchLoginPage();
		loginPage.login(username, "");
		loginPage.assertLoginError();
	}
	
	@Test
	public void testEmptyPasswordAndUsername() {
		PageLauncher.launchLoginPage();
		loginPage.login("", "");
		loginPage.assertLoginError();
	}
	
	@Test
	public void testInvalidUserNameAndPwd() {
		PageLauncher.launchLoginPage();
		loginPage.login("junk", "junk");
		loginPage.assertLoginError();
	}
	
	@Test
	public void testInvalidPasswordButValidUser() throws IOException, URISyntaxException {	
		PageLauncher.launchLoginPage();
		loginPage.login(username, "junk");
		loginPage.assertLoginError();
	}
}
