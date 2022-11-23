package com.utils.ui.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements {

	@FindBy(xpath="//a[text()='Sign in']")
	private WebElement signInLink;

	@FindBy(css="[href='/register/signup']")
	private WebElement signUpLink;

	@FindBy(css=".uni-form__check-indicator")
	private WebElement rememberMeCheckBox;

	@FindBy(css="[data-qa-id='need-help-link']")
	private WebElement needHelpLink;

	@FindBy(css="[data-qa-id='log-in-with-organization-btn']")
	private WebElement logInWithOrganizationBtn;

	@FindBy(css = "#email")
	private WebElement username;

	@FindBy(css = "#password")
	private WebElement password;

	@FindBy(css = "[data-qa-id='login-btn']")
	private WebElement loginButton;
	
	@FindBy(css = "[data-qa-id='error-display']")
	private WebElement errorDisplayElement;


	public WebElement getErrorDisplayElement() {
		return errorDisplayElement;
	}

	public WebElement getNeedHelpLink() {
		return needHelpLink;
	}

	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getSignUpLink() {
		return signUpLink;
	}

	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getLogInWithOrganizationBtn() {
		return logInWithOrganizationBtn;
	}
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
}
